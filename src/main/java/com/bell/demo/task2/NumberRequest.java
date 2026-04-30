package com.bell.demo.task2;

import jakarta.validation.constraints.NotNull;

public record NumberRequest(@NotNull(message = "Число не может быть null") Long number) {
}
