package com.cmcglobal.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cmcglobal.configuration.JwtProvider;
import com.cmcglobal.entity.Role;
import com.cmcglobal.entity.User;
import com.cmcglobal.repository.RoleRepository;
import com.cmcglobal.repository.UserRepository;
import com.cmcglobal.service.impl.UserDetailsServiceImpl;
import com.cmcglobal.utils.RoleName;
import com.cmcglobal.utils.request.LoginForm;
import com.cmcglobal.utils.request.SignUpFrom;
import com.cmcglobal.utils.response.JwtResponse;
import com.cmcglobal.utils.response.ResponseMessage;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/auth")
public class AuthRestAPIs {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtProvider jwtProvider;

	@Autowired
	UserDetailsServiceImpl userDetailsService;

	@GetMapping(value = "/user")
	public List<User> list() {
		List<User> listUsers = userRepository.getUsers();
		return listUsers;
	}

	@PostMapping(value = "/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtProvider.generateJwtToken(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();

		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
	}

	@PostMapping(value = "/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpFrom signUpRequest) {
		// check email có tồn tại không
		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity<>(new ResponseMessage("Faile -> Email is already token !"),
					HttpStatus.BAD_REQUEST);
		}
		// creating users account
		// add từ SignupForm vào user
		User user = new User(signUpRequest.getEmail(), signUpRequest.getFullName(), signUpRequest.getMobile(),
				encoder.encode(signUpRequest.getPassword()), signUpRequest.getStatus());
		// tạo bộ nhớ lưu trữ
		Set<String> strRoles = signUpRequest.getRole();

		Set<Role> roles = new HashSet<>();
		// kiểm tra role truộc 1 trong 3 role
		strRoles.forEach(role -> {
			switch (role) {
			case "admin":
				Role adminRole = roleRepository.findByRoleName(RoleName.ROLE_ADMIN)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role ad not find."));
				roles.add(adminRole);
				break;
			case "mg":
				Role mngRole = roleRepository.findByRoleName(RoleName.ROLE_MANAGER)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role mng not find."));
				roles.add(mngRole);
				break;

			default:
				Role mbRole = roleRepository.findByRoleName(RoleName.ROLE_MEMBER)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role mb not find."));
				roles.add(mbRole);
			}
		});
		// ---------------
		user.setRoles(roles);
		// lưu role
		userRepository.save(user);
		return new ResponseEntity<>(new ResponseMessage("User Registered successfully!"), HttpStatus.OK);

	}

}
