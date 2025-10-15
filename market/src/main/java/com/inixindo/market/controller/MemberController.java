package com.inixindo.market.controller;

import com.inixindo.market.dto.MemberRequest;
import com.inixindo.market.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/member")
public class MemberController {
    //service
    MemberService service;

    //post data
    @PostMapping
    public ResponseEntity tambahData(@RequestBody MemberRequest request){
        return ResponseEntity.ok().body(service.tambah(request));
    }

}
