package com.inixindo.market.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "listing")
public class Listing {
    //atribut
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String judul;
    private String deskripsi;
    private Double harga;
    private String kategori;
    private String username;
    private String nohp;
    // @Lob
    // private Byte[] foto;
}
