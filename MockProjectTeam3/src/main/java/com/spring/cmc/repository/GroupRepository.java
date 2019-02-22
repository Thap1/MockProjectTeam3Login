package com.spring.cmc.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.cmc.entity.Group;

@Repository
public interface GroupRepository extends CrudRepository<Group, Integer>,JpaRepository<Group, Integer>{

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
	@Query("select m from Group m where m.groupName like %:name% or m.createBy like %:name% or m.createDate like %:name%")
	List<Group> findByGroupNameContaining(String name);
	
	/**
	 * Created by: NVTUAN2
	 * Created date: Feb 23, 2019
	 * Modifier: NVTUAN2
	 * Modified date: Feb 23, 2019
	 * Description: add an user and a group into user_group temporary table
	 * Version: 1.0
	 * @param: param
	 * Return Type: void
	 */
	@Transactional
	@Modifying
	@Query(value = "insert into user_group values ( :user_id, :group_id )",nativeQuery = true)
	void addUserIntoGroup(@Param("user_id") int user_id, @Param("group_id") int group_id);
	
	/**
	 * Created by: NVTUAN2
	 * Created date: Feb 23, 2019
	 * Modifier: NVTUAN2
	 * Modified date: Feb 23, 2019
	 * Description: delete user_id and group_id into temporary
	 * Version: 1.0
	 * @param: param
	 * Return Type: void
	 */
	@Transactional
	@Modifying
	@Query(value = "delete from user_group where user_id = :user_id and group_id = :group_id",nativeQuery=true)
	void removeUserIntoGroup(@Param("user_id") int user_id, @Param("group_id") int group_id);
	
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
	Group findByGroupId(int id);
	
}
