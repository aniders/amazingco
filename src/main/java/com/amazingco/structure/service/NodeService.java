package com.amazingco.structure.service;

import java.util.List;

import com.amazingco.structure.entity.Node;

public interface NodeService {

	List<Node> getAllNodes();

	List<Node> getAllChildren(Long nodeId);

	Node updateNode(Long nodeId, Node nodeObject);

	Node save(Node node);

	List<Node> deleteNode(Long nodeId);

	Node getNode(Long nodeId);

}
