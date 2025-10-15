package com.inixindo.market.dto;

import io.micrometer.common.lang.NonNull;

public record ListingRequest (
    @NonNull
    String judul,
    String deskripsi,
    Double harga,
    String kategori,
    String username,
    String nohp
) {
}
