package com.bitecodelab.jpademo.library;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class LibraryAddress {
    @Id
    private Long id;

    @Column(name = "houseNumber", nullable = false)
    private int houseNumber;

    @Column(name = "streetAddress", nullable = false)
    private String streetAddress;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "zipCode", nullable = false)
    private String zipCode;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Library library;
}
