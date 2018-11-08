package com.amazingco.structure.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazingco.structure.BadRequestException;
import com.amazingco.structure.entity.Node;
import com.amazingco.structure.repository.NodeRepository;
import com.amazingco.structure.service.NodeService;

@Service
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
		if(node.getHeight()==0) {
			throw new BadRequestException("Node is a root node");
		}
		Node parentNode = nodeRepository.findOne(nodeObject.getParentId());
		node.setParentId(nodeObject.getParentId());
		node.setHeight(parentNode.getHeight()+1);
		return nodeRepository.save(node);
	}

	@Override
	public Node save(Node node) {
		if (node.getHeight() == 0 ) {
			if(null == nodeRepository.findRootNode()) {
				node.setParentId(node.getId());
				node.setRootId(node.getId());
				return nodeRepository.save(node);
			} else {
				throw new BadRequestException("Root node alreay exists");
			}
		} else {
			return nodeRepository.save(node);
		}
	}

	@Override
	public List<Node> deleteNode(Long nodeId) {
		Node node = nodeRepository.findOne(nodeId);
		if(node.getHeight()==0) {
			throw new BadRequestException("Cannot delete root node");
		}
		nodeRepository.delete(nodeId);
		return nodeRepository.findAll();
	}

	@Override
	public Node getNode(Long nodeId) {
		return nodeRepository.findOne(nodeId);
	}

}
