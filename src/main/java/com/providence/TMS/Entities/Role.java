package com.providence.TMS.Entities;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;


@Entity
public class Role {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String publicId;
    @NotEmpty
    private String name;
    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    public Role(String user) {

    }

    public Role(String name, List<User> users) {
        this.name = name;
        this.users = users;
    }

    public Role() {
    }


    public String getPublicId() {
        return publicId;
    }

    public void setPublicId(String publicId) {
        this.publicId= publicId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
