package com.example.gicws2.demo.Controllers;

import com.example.gicws2.demo.Entity.MyEntity;
import com.example.gicws2.demo.Repository.MyRepository;
import com.example.gicws2.demo.Services.MyService;
import com.example.gicws2.demo.Services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/number5")
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    private MyService myService;

    @Autowired
    private MyRepository myRepository;

    @GetMapping("/test-exception")
    public String testException() {
        // This will throw an ArithmeticException
        int x = 10 / 0;
        return "Result: " + x;
    }

    @GetMapping("/test-aspect")
    public String testAspect() {
        return testService.performTask();
    }

    @GetMapping("/myentity")
    public Page<MyEntity> getItems(Pageable pageable) {
        return myRepository.findAll(pageable);
    }

    @GetMapping("/product/{id}")
    public String getProduct(@PathVariable Long id) {
        return myService.getProductById(id);
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("MyEntity") MyEntity myEntity)
    {
        myService.updateMyEntity(myEntity);
        return "redirect:/user/" + myEntity.getId();
    }

    @GetMapping("/products")
    public @ResponseBody List<MyEntity> getProducts() {
        return myService.getAllProducts();
    }

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            // File handling logic
            return "success";
        }
        return "error";
    }

}
