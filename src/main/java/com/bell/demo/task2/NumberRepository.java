package com.bell.demo.task2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@Repository
public class NumberRepository {
    //для конкурентной среды (полезно в случае тех же нагрузочных)
    private final ConcurrentHashMap<Long, Long> idsAndCalcResults = new ConcurrentHashMap<>();
    private final AtomicLong idCounter = new AtomicLong();

    public void save(Long valueToAdd) {
        if (valueToAdd == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }

        long id = idCounter.getAndIncrement();
        log.info("Saving request id: {} and value: {}", id, valueToAdd);
        idsAndCalcResults.put(id, valueToAdd);
    }

    //без конфига, т.к. простая задача, просто для удобства
    @Scheduled(fixedRate = 7, timeUnit = TimeUnit.SECONDS)
    public void print() {
        log.info("Ids and calc results map: {}", !idsAndCalcResults.isEmpty() ? "\n" + idsAndCalcResults : "empty");
    }

}
