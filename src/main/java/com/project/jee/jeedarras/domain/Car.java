package com.project.jee.darrasjee.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "car")
public class Car {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", unique = true, nullable = false)
        private Long id;

        @Column(name = "registration_nr", nullable = false, length = 8)
        private String registrationNr;

        @Column(name = "brand", nullable = false)
        private String brand;

        @Column(name = "model", nullable = false)
        private String model;

        @Column(name = "is_available", nullable = false)
        private Boolean isAvailable;

        @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
        @JoinColumn(name = "car_package_id", referencedColumnName = "id")
        private CarPackage carPackage;

        @OneToOne(orphanRemoval = true)
        private CarParameters carParameters;

}
