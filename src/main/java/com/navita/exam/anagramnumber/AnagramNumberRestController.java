package com.navita.exam.anagramnumber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("anagram_number")
public class AnagramNumberRestController {

    @Autowired
    private AnagramNumberService anagramNumberService;

    @GetMapping("find_max/{number}")
    public Integer findMax(@PathVariable Integer number) {
        return anagramNumberService.findMaxPossible(number);
    }
}
