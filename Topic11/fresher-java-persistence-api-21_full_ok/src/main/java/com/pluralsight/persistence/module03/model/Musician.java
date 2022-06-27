package com.pluralsight.persistence.module03.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Musician {
    @Id
    private Long id;
    private  String name;

//    @OneToOne
//    @JoinColumn(name = "cd_id")
//    private CD cd;


}
