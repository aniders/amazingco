package com.amazingco.structure.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Data
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "NODE")
public class Node {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "PARENT_NODE")
	private Long parentId;

	@Column(name = "ROOT_NODE")
	private Long rootId;

	@Column(name = "HEIGHT")
	private Integer height;

}
