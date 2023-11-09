package com.github.manu156.app.repository;

import com.github.manu156.app.CommonUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRepository {
    public List<String> getUserRoles() {
        List<String> resp = CommonUtil.getRandomListOfStrings(new ArrayList<>());
        CommonUtil.sleepRandom();
        return resp;
    }
}
