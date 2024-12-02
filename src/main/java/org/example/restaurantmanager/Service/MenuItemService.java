package org.example.restaurantmanager.Service;

/**
 * @author DOAN VY VY on 12/2/2024
 */
import org.example.restaurantmanager.Entity.MenuItem;
import org.example.restaurantmanager.Repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class MenuItemService {

    @Autowired
    private MenuItemRepository menuItemRepository;

    // Lấy tất cả MenuItems
    public List<MenuItem> getAllMenuItems() {
        return menuItemRepository.findAll();
    }

    // Tìm MenuItem theo id
    public Optional<MenuItem> getMenuItemById(Integer id) {
        return menuItemRepository.findById(id);
    }

    // Thêm mới MenuItem
    public MenuItem createMenuItem(MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }

    // Xóa MenuItem theo id
    public void deleteMenuItem(Integer id) {
        menuItemRepository.deleteById(Long.valueOf(id));
    }

    // Tìm MenuItems theo tên
    public List<MenuItem> getMenuItemsByName(String name) {
        return menuItemRepository.findByName(name);
    }

    // Tìm MenuItems theo mức giá
    public List<MenuItem> getMenuItemsByPriceGreaterThan(BigDecimal price) {
        return menuItemRepository.findByPriceGreaterThanEqual(price);
    }

    // Tìm MenuItems theo mức độ ưu tiên
    public List<MenuItem> getMenuItemsByPriorityLevel(Integer priorityLevel) {
        return menuItemRepository.findByPriorityLevel(priorityLevel);
    }

    // Tìm MenuItems trong khoảng thời gian
    public List<MenuItem> getMenuItemsByCreatedAtBetween(Instant startDate, Instant endDate) {
        return menuItemRepository.findByCreatedAtBetween(startDate, endDate);
    }
}
