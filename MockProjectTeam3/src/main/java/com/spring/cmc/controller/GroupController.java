package com.spring.cmc.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cmc.entity.Group;
import com.spring.cmc.entity.User;
//import com.example.team3.entity.UserGroup;
import com.spring.cmc.services.impl.GroupServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class GroupController {

	
	@Autowired
	GroupServiceImpl groupUserService;
	
	
	/**
	 * Created by: NVTUAN2
	 * Created date: Feb 23, 2019
	 * Modifier: NVTUAN2
	 * Modified date: Feb 23, 2019
	 * Description: get all group-user
	 * Version: 1.0
	 * @param: param
	 * Return Type: List<Group>
	 */
	@GetMapping("/product")
	public List<Group> getAllGroupUsers() {
		System.out.println("Get all Group Users...");
		return groupUserService.getAllGroupUser();
	}
	
	/**
	 * Created by: NVTUAN2
	 * Created date: Feb 23, 2019
	 * Modifier: NVTUAN2
	 * Modified date: Feb 23, 2019
	 * Description: edit a group-user
	 * Version: 1.0
	 * @param: param
	 * Return Type: ResponseEntity<Group>
	 */
	@PutMapping("/product/edit/{id}")
	public ResponseEntity<Group> updateGroupUser(@PathVariable("id") int id, @RequestBody Group customer) {
		System.out.println("Update GroupUser with ID = " + id + "...");
 
		Optional<Group> groupUserData = groupUserService.findById(id);
 
		if (groupUserData.isPresent()) {
			Group groupUser = groupUserData.get();
			groupUser.setGroupName(customer.getGroupName());
			groupUser.setCreateBy(customer.getCreateBy());
			groupUser.setCreateDate(customer.getCreateDate());
			return new ResponseEntity<>(groupUserService.saveGroupUser(groupUser), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Created by: NVTUAN2
	 * Created date: Feb 23, 2019
	 * Modifier: NVTUAN2
	 * Modified date: Feb 23, 2019
	 * Description: create a group-user
	 * Version: 1.0
	 * @param: param
	 * Return Type: Group
	 */
	@PostMapping(value = "/product/create")
	public Group createGroupUser(@RequestBody Group groupUser) {

		return groupUserService.createGroupUser(groupUser);
	}

	/**
	 * Created by: NVTUAN2
	 * Created date: Feb 23, 2019
	 * Modifier: NVTUAN2
	 * Modified date: Feb 23, 2019
	 * Description: delete a group-user
	 * Version: 1.0
	 * @param: param
	 * Return Type: ResponseEntity<String>
	 */
	@DeleteMapping("/product/delete/{id}")
	public ResponseEntity<String> deleteGroupUser(@PathVariable("id") int id) {
		System.out.println("Delete GroupUser with ID = " + id + "...");

		groupUserService.deleteGroupUserById(id);

		return new ResponseEntity<>("GroupUser has been deleted!", HttpStatus.OK);
	}

	/**
	 * Created by: NVTUAN2
	 * Created date: Feb 23, 2019
	 * Modifier: NVTUAN2
	 * Modified date: Feb 23, 2019
	 * Description: delete all group user
	 * Version: 1.0
	 * @param: param
	 * Return Type: ResponseEntity<String>
	 */
	@DeleteMapping("/product/delete")
	public ResponseEntity<String> deleteAllGroupUsers() {
		System.out.println("Delete All Customers...");

		groupUserService.deleteAllGroupUser();

		return new ResponseEntity<>("All group-users have been deleted!", HttpStatus.OK);
	}

	/**
	 * Created by: NVTUAN2
	 * Created date: Feb 23, 2019
	 * Modifier: NVTUAN2
	 * Modified date: Feb 23, 2019
	 * Description: get a group-user detail
	 * Version: 1.0
	 * @param: param
	 * Return Type: Group
	 */
	@GetMapping("/product/detail/{id}")
	public Group getGroupUserById(@PathVariable("id") int id) {
		System.out.println("Get Group User By Id..." + id + "...");

		return groupUserService.findByGroupId(id);
	}

	/**
	 * Created by: NVTUAN2
	 * Created date: Feb 23, 2019
	 * Modifier: NVTUAN2
	 * Modified date: Feb 23, 2019
	 * Description: search group user by name
	 * Version: 1.0
	 * @param: param
	 * Return Type: List<Group>
	 */
	@GetMapping("/product/group-user/{name}")
	public List<Group> findByGroupNameContaining(@PathVariable("name") String name) {
		return groupUserService.findByGroupNameContaining(name);
	}
	
	/**
	 * Created by: NVTUAN2
	 * Created date: Feb 23, 2019
	 * Modifier: NVTUAN2
	 * Modified date: Feb 23, 2019
	 * Description: get users from a group
	 * Version: 1.0
	 * @param: param
	 * Return Type: Set<User>
	 */
//	@GetMapping("/product/detail/{id}/users")
//	public Set<User> getUserFromGroup(@PathVariable("id") int id) {
//		System.out.println("Get Group User By Id..." + id + "...");
//
//		Group groupUser = groupUserService.findByGroupId(id);
//		Set<UserGroup> list = groupUser.getUserGroups();
//		
//		Set<User> users = new HashSet<>();
//		
//		for(UserGroup user_group : list) {
//			users.add(user_group.getUser());
//		}
//		
//		return users;
//	}
	
	/**
	 * Created by: NVTUAN2
	 * Created date: Feb 23, 2019
	 * Modifier: NVTUAN2
	 * Modified date: Feb 23, 2019
	 * Description: add a user into a group
	 * Version: 1.0
	 * @param: param
	 * Return Type: Set<User>
	 */
//	@GetMapping("/product/add/{group_id}/users/{user_id}")
//	public Set<User> addUserIntoGroup(@PathVariable("group_id") int group_id, @PathVariable("user_id") int user_id) {
//		System.out.println("ADD USER INTO GROUP BY ID ... GROUP_ID = " + group_id + "... USER_ID = " + user_id);
//		groupUserService.addUserIntoGroup(user_id, group_id);
//		Group groupUser = groupUserService.findByGroupId(group_id);
//		Set<UserGroup> list = groupUser.getUserGroups();
//		
//		Set<User> users = new HashSet<>();
//		
//		for(UserGroup user_group : list) {
//			users.add(user_group.getUser());
//		}
//		
//		return users;
//	}
	
	/**
	 * Created by: NVTUAN2
	 * Created date: Feb 23, 2019
	 * Modifier: NVTUAN2
	 * Modified date: Feb 23, 2019
	 * Description: delete a user from a group
	 * Version: 1.0
	 * @param: param
	 * Return Type: Set<User>
	 */
//	@GetMapping("/product/delete/{group_id}/users/{user_id}")
//	public Set<User> removeUserIntoGroup(@PathVariable("group_id") int group_id, @PathVariable("user_id") int user_id) {
//		System.out.println("ADD USER INTO GROUP BY ID ... GROUP_ID = " + group_id + "... USER_ID = " + user_id);
//		groupUserService.removeUserIntoGroup(user_id, group_id);
//		Group groupUser = groupUserService.findByGroupId(group_id);
//		Set<UserGroup> list = groupUser.getUserGroups();
//		
//		Set<User> users = new HashSet<>();
//		
//		for(UserGroup user_group : list) {
//			users.add(user_group.getUser());
//		}
//		
//		return users;
//	}
}
