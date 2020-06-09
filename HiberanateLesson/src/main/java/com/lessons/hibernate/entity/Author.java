package com.lessons.hibernate.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
@Entity
@Setter
@Getter
public class Author implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY) // генерация ID через Autoincrement в MySQL
    private long id;
    private String name;

}
