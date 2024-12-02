package org.example.restaurantmanager.Repository;

import org.example.restaurantmanager.Entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

/**
 * @author DOAN VY VY on 12/2/2024
 */
@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
    // Truy vấn tìm MenuItem theo tên (có thể thay đổi tùy theo yêu cầu)
    List<MenuItem> findByName(String name);

    // Truy vấn tìm MenuItem theo mức độ ưu tiên
    List<MenuItem> findByPriorityLevel(Integer priorityLevel);

    // Truy vấn tìm MenuItem theo mức giá
    List<MenuItem> findByPriceGreaterThanEqual(BigDecimal price);

    // Truy vấn tìm MenuItem theo mức giá nhỏ hơn một giá trị
    List<MenuItem> findByPriceLessThanEqual(BigDecimal price);

    // Tìm MenuItem theo ID (tự động có sẵn từ JpaRepository)
    Optional<MenuItem> findById(Integer id);

    // Truy vấn tất cả các MenuItem theo thứ tự giá tăng dần (có thể sửa tùy theo yêu cầu)
    List<MenuItem> findAllByOrderByPriceAsc();

    // Truy vấn tất cả MenuItem có thời gian tạo trong khoảng thời gian nhất định
    List<MenuItem> findByCreatedAtBetween(Instant startDate, Instant endDate);

    // Truy vấn tất cả MenuItem có mức độ ưu tiên lớn hơn một giá trị nhất định
    List<MenuItem> findByPriorityLevelGreaterThan(Integer priorityLevel);

    // Các phương thức tùy chỉnh khác có thể được thêm vào tùy theo yêu cầu
}
