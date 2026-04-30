package com.bell.demo.task2;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class NumberController {
    private final NumberService numberService;

    @PostMapping("/square")
    public ResponseEntity<Long> calculateSquare(@Valid @RequestBody NumberRequest request) {
        Long result = numberService.calculateSquare(request.number());

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
