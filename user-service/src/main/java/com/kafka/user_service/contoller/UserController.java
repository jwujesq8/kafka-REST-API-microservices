package com.kafka.user_service.contoller;

import com.kafka.inventory_service.dto.InventoryDto;
import com.kafka.user_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Validated
public class UserController {

    private final UserService userService;

    @PostMapping("/signIn")
    public void signIn(){

    }

    @PostMapping("/logIn")
    public void logIn(){

    }

    @PostMapping("/admin")
    public void confirmAdmin(){

    }

    @GetMapping
    public List<InventoryDto> requestAndShowInventoryList(@RequestParam(name = "page", defaultValue = "1") int page,
                                                          @RequestParam(name = "size", required = false,
                                                                  defaultValue = "3") int size){
        return userService.requestAndShowInventoryList(page, size);
    }




}
