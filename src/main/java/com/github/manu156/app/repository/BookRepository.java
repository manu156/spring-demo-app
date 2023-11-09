package com.github.manu156.app.repository;

import com.github.manu156.app.CommonUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository {
    public boolean isBookComplete(String name) {
        int k = 0;
        for (int i = 0; i < 9000000; i++) {
            k = (k + i) % 14;
        }

        return k % 99 == 0 && !name.isEmpty();
    }

    public boolean isBookAvailable(String name) {
        int k = 0;
        for (int i = 0; i < 8000000; i++) {
            k = (k + i) % 14;
        }

        return k % 89 == 0 || !name.isEmpty();
    }

    public void addBasicBookDetails(List<String> books) {
        CommonUtil.sleepRandom();
    }
}
