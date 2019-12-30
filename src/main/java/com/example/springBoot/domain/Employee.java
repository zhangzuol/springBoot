package com.example.springBoot.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMP_TB_SEQ")
    @SequenceGenerator(sequenceName = "EMP_TB_SEQ", allocationSize = 1, name = "EMP_TB_SEQ")
    private Long id;
    @Column
    private String name;
    @Column
    private String address;
    @Column
    private String position;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", position='" + position + '\'' +
                '}';
    }

}
