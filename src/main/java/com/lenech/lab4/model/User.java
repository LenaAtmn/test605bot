package com.lenech.lab4.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    private int id;
    private String name;
    private String link;
    private Boolean banstatus;

    public User() {
    }

    public User(int id, String name, String link, Boolean banstatus) {
        this.id = id;
        this.name = name;
        this.link = link;
        this.banstatus = banstatus;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "link", nullable = false)
    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }

    @Column(name = "banstatus", nullable = false)
    public Boolean getBanstatus() {
        return banstatus;
    }
    public void setBanstatus(Boolean banstatus) {
        this.banstatus = banstatus;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", link='" + link + '\'' +
                ", banstatus=" + banstatus +
                '}';
    }
}
