package com.spring.cmc.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.cmc.entity.Group;
import com.spring.cmc.repository.GroupRepository;
import com.spring.cmc.services.GroupService;

@Service
public class GroupServiceImpl implements GroupService{

	@Autowired
	private GroupRepository groupUserRepository;

	// show all group-user
	@Override
	public List<Group> getAllGroupUser() {
		List<Group> list = new ArrayList<>();
		groupUserRepository.findAll().forEach(list::add);
		return list;
	}
	
	// find group by id. Use in edit a group 
	@Override
	public Optional<Group> findById(int id) {
		Optional<Group> groupUser = groupUserRepository.findById(id);
		return groupUser;
	}

	// save group-user
	@Override
	public Group saveGroupUser(Group object) {
		return groupUserRepository.save(object);
	}

	// delete group-user by id
	@Override
	public void deleteGroupUserById(int id) {
		groupUserRepository.deleteById(id);
	}
	
	// delete group-user by id
	@Override
	public void deleteAllGroupUser() {
		groupUserRepository.deleteAll();
	}

	// search by group-name
	@Override
	public List<Group> findByGroupNameContaining(String name) {
		List<Group> listgroupUser = groupUserRepository.findByGroupNameContaining(name);
		return listgroupUser;
	}

	// find group user by id. Use in get a group detail
	@Override
	public Group findByGroupId(int groupUserId) {
		Group groupUser = groupUserRepository.findByGroupId(groupUserId);
		return groupUser;
	}
	
	// create a group-user
	@Override
	public Group createGroupUser(@RequestBody Group groupUser) {
		Group newGroupUser = groupUserRepository.save(new Group(groupUser.getGroupName(), groupUser.getCreateBy(), groupUser.getCreateDate()));
		return newGroupUser;
	}
	
	// add an user and a group into user_group temporary table
	@Override
	public void addUserIntoGroup(int user_id, int group_id) {
		groupUserRepository.addUserIntoGroup(user_id, group_id);
	}
	
	// delete an user and a group into user_group temporary table
	@Override
	public void removeUserIntoGroup(int user_id, int group_id) {
		groupUserRepository.removeUserIntoGroup(user_id, group_id);
	}
}
