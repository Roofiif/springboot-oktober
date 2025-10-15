package com.inixindo.market.controller;

import com.inixindo.market.dto.ListingRequest;
import com.inixindo.market.service.ListingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/listing")
public class ListingController {
    //service listing
    ListingService service;

    //post data
    @PostMapping
    public ResponseEntity<?> tambahData(@RequestBody ListingRequest request){
        return ResponseEntity.ok().body(service.tambah(request));
    }

    //ambil data listing
    @GetMapping
    public ResponseEntity<?> tampilListing(){
        return ResponseEntity.ok().body(service.tampilListing());
    }
}
