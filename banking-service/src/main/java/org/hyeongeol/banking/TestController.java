package org.hyeongeol.banking;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class TestController {

    @GetMapping(path= "/test")
    void test() {
        System.out.println("welcome to my pay world!");
    }

}
