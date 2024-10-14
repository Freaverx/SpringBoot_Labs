package ru.proskuryakov.MyFirstTestAppSpringBoot.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CollectionController {

    private List<String> arrayList = new ArrayList<>();
    private Map<Integer, String> hashMap = new HashMap<>();
    private int mapKeyCounter = 0;

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/update-array")
    public String updateArrayList(@RequestParam(value = "value") String value) {
        arrayList.add(value);
        return String.format("Added '%s' to ArrayList. Current size: %d", value, arrayList.size());
    }

    @GetMapping("/show-array")
    public List<String> showArrayList() {
        return arrayList;
    }

    @GetMapping("/update-map")
    public String updateHashMap(@RequestParam(value = "value") String value) {
        hashMap.put(mapKeyCounter++, value);
        return String.format("Added '%s' to HashMap with key %d. Current size: %d", value, mapKeyCounter - 1, hashMap.size());
    }

    @GetMapping("/show-map")
    public Map<Integer, String> showHashMap() {
        return hashMap;
    }

    @GetMapping("/show-all-length")
    public String showAllLength() {
        return String.format("ArrayList size: %d, HashMap size: %d", arrayList.size(), hashMap.size());
    }
}
