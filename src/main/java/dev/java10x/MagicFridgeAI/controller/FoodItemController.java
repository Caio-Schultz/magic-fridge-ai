package dev.java10x.MagicFridgeAI.controller;

import dev.java10x.MagicFridgeAI.model.FoodItemDTO;
import dev.java10x.MagicFridgeAI.service.FoodItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodItemController {

    private final FoodItemService foodItemService;

    public FoodItemController(FoodItemService foodItemService) {
        this.foodItemService = foodItemService;
    }

    // CRIAR
    @PostMapping("/create")
    public ResponseEntity<FoodItemDTO> create(@RequestBody FoodItemDTO foodItemDTO){
        FoodItemDTO salvo = foodItemService.create(foodItemDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(salvo);
    }

    // GET
    @GetMapping("/list")
    public ResponseEntity<?> listFoods(){
        List<FoodItemDTO> itens = foodItemService.listFoods();
        return ResponseEntity.ok(itens);
    }

    // GET
    @GetMapping("/list/{id}")
    public ResponseEntity<?> listFoodById(@PathVariable Long id){
        FoodItemDTO food = foodItemService.listFoodByID(id);
        if(food != null){
            return ResponseEntity.ok(food);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("ID " + id + " não corresponde a nenhum alimento!");
        }
    }

    // UPDATE
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody FoodItemDTO foodItemDTO){
        FoodItemDTO food = foodItemService.listFoodByID(id);
        if(food != null){
            foodItemService.update(id, foodItemDTO);
            return ResponseEntity.ok("Alimento atualizado com sucesso!");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("ID " + id + " não corresponde a nenhum alimento!");
        }
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        if(foodItemService.listFoodByID(id) != null){
            foodItemService.delete(id);
            return ResponseEntity.ok("Alimento deletado com sucesso!");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("ID " + id + " não corresponde a nenhum alimento!");
        }
    }


}
