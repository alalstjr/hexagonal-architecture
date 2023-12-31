package com.example.mvc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "MACBOOK")
public class MacBookJpaEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Long batteryId;

    private String name;

    private String code;
}
