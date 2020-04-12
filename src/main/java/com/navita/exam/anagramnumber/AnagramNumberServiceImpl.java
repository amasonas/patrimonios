package com.navita.exam.anagramnumber;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class AnagramNumberServiceImpl implements AnagramNumberService {

    private Integer MAXIMUM = 1000000;

    @Override
    public Integer findMaxPossible(Integer rootNumber) {
        if (rootNumber <= MAXIMUM) {
            String numberStr = String.valueOf(rootNumber);
            List<String> digits = Arrays.asList(numberStr.split(""));
            StringBuilder result = new StringBuilder();

            Collections.sort(digits, Collections.reverseOrder());

            digits.forEach(digit -> {
                result.append(digit);
            });

            return Integer.parseInt(result.toString());
        } else {
            return -1;
        }
    }
}
