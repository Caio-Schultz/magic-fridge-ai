package dev.java10x.MagicFridgeAI.model;

import org.springframework.stereotype.Component;

@Component
public class FoodItemMapper {

    public FoodItemModel map(FoodItemDTO foodItemDTO){
        FoodItemModel foodItemModel = new FoodItemModel();
        foodItemModel.setId(foodItemDTO.getId());
        foodItemModel.setName(foodItemDTO.getName());
        foodItemModel.setCategory(foodItemDTO.getCategory());
        foodItemModel.setQuantity(foodItemDTO.getQuantity());
        foodItemModel.setExpirationDate(foodItemDTO.getExpirationDate());

        return foodItemModel;
    }

    public FoodItemDTO map(FoodItemModel foodItemModel){
        FoodItemDTO foodItemDTO = new FoodItemDTO();
        foodItemDTO.setId(foodItemModel.getId());
        foodItemDTO.setName(foodItemModel.getName());
        foodItemDTO.setCategory(foodItemModel.getCategory());
        foodItemDTO.setQuantity(foodItemModel.getQuantity());
        foodItemDTO.setExpirationDate(foodItemModel.getExpirationDate());

        return foodItemDTO;
    }

}
