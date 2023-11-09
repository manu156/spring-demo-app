package com.github.manu156.app.repository;

import com.github.manu156.app.CommonUtil;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Repository
public class BorrowingRepository {
    public Collection<String> getBooksForUserAndRole(Long userId, String role) {
        List<String> resp = CommonUtil.getRandomListOfStrings(Collections.singletonList(role));
        CommonUtil.sleep(userId % 100);
        return resp;
    }

    public Collection<String> getPastBorrowedBooks(Long userId, String role) {
        CommonUtil.sleep(userId % 200);
        return CommonUtil.getRandomListOfStrings(Collections.singletonList(role));
    }
}
