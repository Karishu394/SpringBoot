package com.examly.springapp.service;

import com.examly.springapp.model.RoomCategory;
import java.util.List;

public interface RoomCategoryService {

    RoomCategory addRoomCategory(RoomCategory roomCategory);

    List<RoomCategory> getAllRoomCategories();

    RoomCategory getRoomCategoryById(Long id);

    RoomCategory updateRoomCategory(RoomCategory roomCategory);
}
