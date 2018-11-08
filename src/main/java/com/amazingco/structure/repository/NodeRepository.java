package com.amazingco.structure.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.amazingco.structure.entity.Node;

public interface NodeRepository extends JpaRepository<Node, Long> {
	
	  @Query("SELECT * FROM Node n WHERE n.parentId = ?1")
	  List<Node> findAllByParentId(Long nodeId);

}
