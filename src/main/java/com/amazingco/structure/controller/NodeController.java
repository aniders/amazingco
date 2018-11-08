package com.amazingco.structure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.amazingco.structure.entity.Node;
import com.amazingco.structure.service.NodeService;

import io.swagger.annotations.ApiOperation;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NodeController {

	@Autowired
	private NodeService nodeService;

	@PostMapping("/nodes")
	public Node create(@RequestBody Node node) {
		return nodeService.save(node);
	}

	@GetMapping("/nodes")
	public List<Node> findAll() {
		return nodeService.getAllNodes();
	}

	@GetMapping("/nodes/{node_id}")
	@ApiOperation(value = "Get all children nodes of a given node", produces = "application/json")
	public List<Node> findAllChildren(@PathVariable("node_id") Long nodeId) {
		return nodeService.getAllChildren(nodeId);
	}

	@PutMapping("/nodes/{node_id}")
	@ApiOperation(value = "Change parent node of given node", produces = "application/json")
	public Node update(@PathVariable("node_id") Long nodeId, @RequestBody Node nodeObject) {
		return nodeService.updateNode(nodeId, nodeObject);
	}

	@DeleteMapping("/nodes/{node_id}")
	public List<Node> delete(@PathVariable("node_id") Long nodeId) {
		return nodeService.deleteNode(nodeId);
	}

}
