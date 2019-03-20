package com.bitecodelab.jpademo.library;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class LibraryAddress {
    @Id
    @GeneratedValue
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
    @JoinColumn(name = "library_id")
    private Library library;
}
