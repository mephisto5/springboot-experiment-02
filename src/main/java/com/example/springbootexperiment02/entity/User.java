package com.example.springbootexperiment02.entity;
import com.example.springbootexperiment02.entity.Address;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE)
    private List<Address> addresses;
    @Column(columnDefinition="TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP",insertable=false,updatable=false)
    private LocalDateTime insertTime;
    public User(String name){
        this.name=name;
    }
}
