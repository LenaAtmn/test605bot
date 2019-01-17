package com.lenech.lab4.model;

import javax.persistence.*;

@Entity
@Table(name = "chat")
public class Chat {
    private int id;
    private String title;
    private String link;
    
    public Chat() {
    }

    public Chat(int id, String title, String link) {
        this.id = id;
        this.title = title;
        this.link = link;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "title", nullable = false)
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "link", nullable = false)
    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
