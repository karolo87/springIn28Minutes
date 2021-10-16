package com.example.springIn28Minutes.repository;

import com.example.springIn28Minutes.entity.Gift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiftRepository extends JpaRepository<Gift, Long> {

}
