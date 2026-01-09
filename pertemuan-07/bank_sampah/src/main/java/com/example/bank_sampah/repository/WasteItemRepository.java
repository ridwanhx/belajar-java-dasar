package com.example.bank_sampah.repository;

import com.example.bank_sampah.model.WasteItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WasteItemRepository extends MongoRepository<WasteItem, String> {
}