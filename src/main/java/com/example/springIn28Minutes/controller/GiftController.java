package com.example.springIn28Minutes.controller;

import com.example.springIn28Minutes.dto.GiftDto;
import com.example.springIn28Minutes.entity.Gift;
import com.example.springIn28Minutes.service.GiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/gift")
public class GiftController {

    private GiftService giftService;

    @Autowired
    public GiftController(GiftService giftService) {
        this.giftService = giftService;
    }

    @GetMapping
    public List<Gift> findAll() {
        return this.giftService.findAll();
    }

    @GetMapping("/{giftId}")
    public Gift findById(@PathVariable Long giftId) {
        return this.giftService.findById(giftId);
    }

    @PostMapping
    public ResponseEntity<Gift> addGift(@RequestBody GiftDto giftDto) {

        Gift gift = this.giftService.save(giftDto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(gift.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }

}
