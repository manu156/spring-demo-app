package com.github.manu156.app.service;

import com.github.manu156.app.CommonUtil;
import org.springframework.stereotype.Service;

@Service
public class OauthService {

    public void verifyUser(Long userId) throws RuntimeException {
        CommonUtil.sleep(100);
    }
}
