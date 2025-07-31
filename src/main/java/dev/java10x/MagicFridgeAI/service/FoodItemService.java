package dev.java10x.MagicFridgeAI.service;

import dev.java10x.MagicFridgeAI.model.FoodItemDTO;
import dev.java10x.MagicFridgeAI.model.FoodItemMapper;
import dev.java10x.MagicFridgeAI.model.FoodItemModel;
import dev.java10x.MagicFridgeAI.repository.FoodItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FoodItemService {

    private final FoodItemRepository foodItemRepository;
    private final FoodItemMapper foodItemMapper;

    public FoodItemService(FoodItemRepository foodItemRepository, FoodItemMapper foodItemMapper) {
        this.foodItemRepository = foodItemRepository;
        this.foodItemMapper = foodItemMapper;
    }

    public FoodItemDTO create(FoodItemDTO foodItemDTO){
       FoodItemModel food = foodItemRepository.save(foodItemMapper.map(foodItemDTO));
       return foodItemMapper.map(food);
    }

    public List<FoodItemDTO> listFoods(){
        List<FoodItemModel> items = foodItemRepository.findAll();
        return items.stream()
                .map(foodItemMapper::map)
                .collect(Collectors.toList());
    }

    public FoodItemDTO listFoodByID(Long id){
        Optional<FoodItemModel> food = foodItemRepository.findById(id);
        return food.map(foodItemMapper::map).orElse(null);
    }

    public void delete(Long id){
        foodItemRepository.deleteById(id);
    }

    public FoodItemDTO update(Long id, FoodItemDTO foodItemDTO){
        if(foodItemRepository.existsById(id)){
            FoodItemModel updatedFood = foodItemMapper.map(foodItemDTO);
            updatedFood.setId(id);
            FoodItemModel savedFood = foodItemRepository.save(updatedFood);
            return foodItemMapper.map(savedFood);
        }
        else {
            return null;
        }
    }



}


