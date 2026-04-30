package com.bell.demo.task2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NumberService {
    private final NumberRepository numberRepository;

    public Long calculateSquare(Long number) {
        if (number == null) {
            throw new IllegalArgumentException("Number cannot be null");
        }

        long squareOfNumber = number * number;

        numberRepository.save(squareOfNumber);

        return squareOfNumber;
    }
}
