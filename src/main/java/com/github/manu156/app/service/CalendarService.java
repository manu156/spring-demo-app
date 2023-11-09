package com.github.manu156.app.service;

import com.github.manu156.app.CommonUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarService {

    public void addBookBorrowingSchedule(List<String> books) {
        CommonUtil.sleepRandom();
    }
}
