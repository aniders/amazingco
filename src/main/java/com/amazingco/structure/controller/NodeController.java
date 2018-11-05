package com.amazingco.structure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.amazingco.structure.entity.Node;
import com.amazingco.structure.repository.NodeRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NodeController {

	@Autowired
	private NodeRepository nodeRepository;

	@PostMapping("/nodess")
	public Node create(@RequestBody Node node) {
		return nodeRepository.save(node);
	}

	@GetMapping("/nodes")
	public List<Node> findAll() {
		return nodeRepository.findAll();
	}

	@PutMapping("/nodes/{node_id}")
	public Node update(@PathVariable("node_id") Long nodeId, @RequestBody Node nodeObject) {
		Node node = nodeRepository.findOne(nodeId);
		node.setParentId(nodeObject.getParentId());
//        node.setRootId(nodeObject.getRootId());
		node.setHeight(nodeObject.getHeight());
		return nodeRepository.save(node);
	}

	@DeleteMapping("/nodes/{node_id}")
	public List<Node> delete(@PathVariable("node_id") Long nodeId) {
		nodeRepository.delete(nodeId);
		return nodeRepository.findAll();
	}

	@GetMapping("/nodes/{node_id}")
	@ResponseBody
	public Node findByUserId(@PathVariable("node_id") Long nodeId) {
		return nodeRepository.findOne(nodeId);
	}
}
