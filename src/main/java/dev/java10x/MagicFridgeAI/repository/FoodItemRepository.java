package dev.java10x.MagicFridgeAI.repository;

import dev.java10x.MagicFridgeAI.model.FoodItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItemModel, Long> {
}
