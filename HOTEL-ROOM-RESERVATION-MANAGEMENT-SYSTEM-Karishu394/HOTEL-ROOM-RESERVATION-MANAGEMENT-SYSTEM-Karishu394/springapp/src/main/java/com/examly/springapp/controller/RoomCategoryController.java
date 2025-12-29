package com.examly.springapp.controller;

import com.examly.springapp.model.RoomCategory;
import com.examly.springapp.service.RoomCategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/room-categories")
public class RoomCategoryController {

    @Autowired
    private RoomCategoryServiceImpl roomCategoryService;

    @PostMapping
    public ResponseEntity<?> addCategory(@RequestBody(required = false) RoomCategory roomCategory) {
        if (roomCategory == null) {
            return ResponseEntity.badRequest().build();
        }
        RoomCategory saved = roomCategoryService.addRoomCategory(roomCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public ResponseEntity<?> getAllCategories() {
        List<RoomCategory> categories = roomCategoryService.getAllRoomCategories();
        if (categories.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Long id) {
        RoomCategory category = roomCategoryService.getRoomCategoryById(id);
        if (category == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Room category not found");
        }
        return ResponseEntity.ok(category);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Long id, @RequestBody RoomCategory roomCategory) {
        roomCategory.setCategoryId(id.intValue());
        RoomCategory updated = roomCategoryService.updateRoomCategory(roomCategory);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/page/{page}/{size}")
    public ResponseEntity<Page<RoomCategory>> getAllCategoriesPaginated(
            @PathVariable int page, @PathVariable int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<RoomCategory> categories = roomCategoryService.getAllRoomCategories(pageable);
        return ResponseEntity.ok(categories);
    }
}

