package com.inixindo.market.service;

import com.inixindo.market.dto.ListingRequest;
import com.inixindo.market.dto.ListingResponse;
import com.inixindo.market.model.Listing;
import com.inixindo.market.repository.ListingRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ListingService {

    //repo
    private final ListingRepository repo;

    //fungsi tambah data
    @Transactional
    public String tambah(ListingRequest request){
        Listing baru = new Listing();
        baru.setJudul(request.judul());
        baru.setDeskripsi(request.deskripsi());
        baru.setHarga(request.harga());
        baru.setKategori(request.kategori());
        baru.setUsername(request.username());
        baru.setNohp(request.nohp());

        //simpan
        repo.save(baru);

        return "Berhasil input data";
    }

    //ambil data listing
//    @Transactional
//    public List<Listing> tampilListing(){
//        return repo.findAll();
//    }

    public List<ListingResponse> tampilListing(){
        List<Listing> listing = repo.findAll();
        return listing.stream()
                .map(val -> new ListingResponse(
                        val.getJudul(),
                        val.getDeskripsi(),
                        val.getHarga()
                ))
                .toList();
    }
}
