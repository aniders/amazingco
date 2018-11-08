package com.amazingco.structure.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.amazingco.structure.entity.Node;
import com.amazingco.structure.repository.NodeRepository;
import com.amazingco.structure.service.NodeService;

public class NodeServiceImpl implements NodeService {

	@Autowired
	private NodeRepository nodeRepository;

	@Override
	public List<Node> getAllNodes() {
		return nodeRepository.findAll();
	}

	@Override
	public List<Node> getAllChildren(Long nodeId) {
		return nodeRepository.findAllByParentId(nodeId);
	}

	@Override
	public Node updateNode(Long nodeId, Node nodeObject) {
		Node node = nodeRepository.findOne(nodeId);
		Node parentNode = nodeRepository.findOne(nodeObject.getParentId());
		node.setParentId(nodeObject.getParentId());
		node.setHeight(parentNode.getHeight()+1);
		return nodeRepository.save(node);
	}

	@Override
	public Node save(Node node) {
		return nodeRepository.save(node);
	}

	@Override
	public List<Node> deleteNode(Long nodeId) {
		nodeRepository.delete(nodeId);
		return nodeRepository.findAll();
	}

	@Override
	public Node getNode(Long nodeId) {
		return nodeRepository.findOne(nodeId);
	}

}
