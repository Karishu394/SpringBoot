package com.examly.springapp.service;

import com.examly.springapp.model.RoomCategory;
import com.examly.springapp.repository.RoomCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoomCategoryServiceImpl implements RoomCategoryService {

    @Autowired
    private RoomCategoryRepo roomCategoryRepo;

    @Override
    public RoomCategory addRoomCategory(RoomCategory roomCategory) {
        return roomCategoryRepo.save(roomCategory);
    }

    @Override
    public List<RoomCategory> getAllRoomCategories() {
        return roomCategoryRepo.findAll();
    }

    @Override
    public RoomCategory getRoomCategoryById(Long id) {
        return roomCategoryRepo.findById(id).orElse(null);
    }

    @Override
    public RoomCategory updateRoomCategory(RoomCategory roomCategory) {
        return roomCategoryRepo.save(roomCategory);
    }

    public Page<RoomCategory> getAllRoomCategories(Pageable pageable) {
        return roomCategoryRepo.findAll(pageable);
    }
}