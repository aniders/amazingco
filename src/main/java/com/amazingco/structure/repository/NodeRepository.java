package com.amazingco.structure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amazingco.structure.entity.Node;

public interface NodeRepository extends JpaRepository<Node, Long> {

}
