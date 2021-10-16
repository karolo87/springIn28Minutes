package com.example.springIn28Minutes.service;

import com.example.springIn28Minutes.dto.GiftDto;
import com.example.springIn28Minutes.entity.Gift;
import com.example.springIn28Minutes.exception.NoSuchGiftException;
import com.example.springIn28Minutes.repository.GiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GiftService {

    private GiftRepository giftRepository;

    public GiftService() {
    }

    @Autowired
    public GiftService(GiftRepository giftRepository) {
        this.giftRepository = giftRepository;
    }

    public Gift save(GiftDto giftDto) {

        return giftRepository.save(createGiftFromDto(giftDto));
    }

    public List<Gift> findAll() {
        return this.giftRepository.findAll();
    }

    private static Gift createGiftFromDto(GiftDto giftDto) {
        Gift gift = new Gift();
        gift.setName(giftDto.getName());
        gift.setDescription(giftDto.getDescription());
        return gift;
    }

    public Gift findById(Long id) {
        return this.giftRepository.findById(id).orElseThrow(() -> new NoSuchGiftException(String.format("Gift with id %s does not exist", id)));
    }
}
