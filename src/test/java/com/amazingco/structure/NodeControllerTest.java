package com.amazingco.structure;

import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.security.Principal;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.amazingco.structure.controller.NodeController;
import com.amazingco.structure.entity.Node;
import com.amazingco.structure.service.NodeService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class NodeControllerTest {

	private MockMvc mockMvc;

	@Mock
	private NodeService nodeServiceMock;

	@InjectMocks
	private NodeController nodeController;

	@Mock
	private Principal principal;

	@Mock
	private SecurityContext securityContext;

	private ObjectMapper objectMapper = new ObjectMapper();

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(nodeController).build();
	}

	@Test
	public void changeParentTest() throws Exception {
		Node node = Node.builder().id(1234l).height(3).parentId(2222l).rootId(1111l).build();
		String json = objectMapper.writeValueAsString(node);
		Node updatedNode = Node.builder().id(1234l).height(3).parentId(2222l).rootId(1111l).build();
		when(principal.getName()).thenReturn("app1");
		when(nodeServiceMock.updateNode(anyObject(), anyObject())).thenReturn(updatedNode);

		mockMvc.perform(put("/api/nodes/1234").principal(principal).content(json).contentType(APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$.id", is(1234)))
				.andExpect(jsonPath("$.parentId", is(2222)));

	}

}
