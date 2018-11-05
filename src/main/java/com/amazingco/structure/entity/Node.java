package com.amazingco.structure.entity;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "NODE")
public class Node {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Long id;

    @Column(name="PARENT_NODE")
    private String parentId;
    
    @Column(name="ROOT_NODE")
    private String rootId;

    @Column(name="HEIGHT")
    private Integer height;

    
}
