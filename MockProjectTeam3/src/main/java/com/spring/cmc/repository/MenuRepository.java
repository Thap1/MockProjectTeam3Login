package com.spring.cmc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.cmc.entity.Menu;

@Repository
public interface MenuRepository extends CrudRepository<Menu, Integer>{
	
	@Query("select m from Menu m where m.menuName like %:name% or m.menuDescription like %:name% or m.menuFunction like %:name%")
	List<Menu> findByMenuNameContaining(String name);
	
	Menu findByMenuId(int id);

}
