package com.election.backendjava.entities;

import jakarta.persistence.*;

/**
 * Entity class representing a role in the system.
 * This class is mapped to the "Role" table in the database using Hibernate.
 */
@Entity
@Table(name = "Role")
public class Role {
    public static final int USER_ROLE_ID = 2;


    /**
     * The unique ID of the role
     */
    @Id
    private int id;

    /**
     * The name of the role.
     */
    @Column(name = "roleName")
    private String roleName;

    public Role() {}

    public Role(int id) { this.id = id; }
}
