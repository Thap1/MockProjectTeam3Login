package com.spring.cmc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestBody;
import com.spring.cmc.entity.Group;

public interface GroupService {

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
	List<Group> getAllGroupUser();
	
	/**
	 * Created by: NVTUAN2
	 * Created date: Feb 23, 2019
	 * Modifier: NVTUAN2
	 * Modified date: Feb 23, 2019
	 * Description: find group by id. Use in edit a group 
	 * Version: 1.0
	 * @param: param
	 * Return Type: Optional<Group>
	 */
	Optional<Group> findById(int id);
	
	/**
	 * Created by: NVTUAN2
	 * Created date: Feb 23, 2019
	 * Modifier: NVTUAN2
	 * Modified date: Feb 23, 2019
	 * Description: save a group into database
	 * Version: 1.0
	 * @param: param
	 * Return Type: Group
	 */
	Group saveGroupUser(Group object);
	
	/**
	 * Created by: NVTUAN2
	 * Created date: Feb 23, 2019
	 * Modifier: NVTUAN2
	 * Modified date: Feb 23, 2019
	 * Description: delete a group by id
	 * Version: 1.0
	 * @param: param
	 * Return Type: void
	 */
	void deleteGroupUserById(int id);
	
	/**
	 * Created by: NVTUAN2
	 * Created date: Feb 23, 2019
	 * Modifier: NVTUAN2
	 * Modified date: Feb 23, 2019
	 * Description: delete all group-user
	 * Version: 1.0
	 * @param: param
	 * Return Type: void
	 */
	void deleteAllGroupUser();
	
	/**
	 * Created by: NVTUAN2
	 * Created date: Feb 23, 2019
	 * Modifier: NVTUAN2
	 * Modified date: Feb 23, 2019
	 * Description: search group-user by name
	 * Version: 1.0
	 * @param: param
	 * Return Type: List<Group>
	 */
	List<Group> findByGroupNameContaining(String name);
		
	/**
	 * Created by: NVTUAN2
	 * Created date: Feb 23, 2019
	 * Modifier: NVTUAN2
	 * Modified date: Feb 23, 2019
	 * Description: find group user by id. Use in get a group detail
	 * Version: 1.0
	 * @param: param
	 * Return Type: Group
	 */
	Group findByGroupId(int groupUserId);
	
	/**
	 * Created by: NVTUAN2
	 * Created date: Feb 23, 2019
	 * Modifier: NVTUAN2
	 * Modified date: Feb 23, 2019
	 * Description: create a new group-user
	 * Version: 1.0
	 * @param: param
	 * Return Type: Group
	 */
	Group createGroupUser(@RequestBody Group groupUser);
	
	/**
	 * Created by: NVTUAN2
	 * Created date: Feb 23, 2019
	 * Modifier: NVTUAN2
	 * Modified date: Feb 23, 2019
	 * Description: add a user into a group
	 * Version: 1.0
	 * @param: param
	 * Return Type: void
	 */
	void addUserIntoGroup(int user_id, int group_id);
	
	/**
	 * Created by: NVTUAN2
	 * Created date: Feb 23, 2019
	 * Modifier: NVTUAN2
	 * Modified date: Feb 23, 2019
	 * Description: delete a group from a group
	 * Version: 1.0
	 * @param: param
	 * Return Type: void
	 */
	void removeUserIntoGroup(int user_id, int group_id);
}
