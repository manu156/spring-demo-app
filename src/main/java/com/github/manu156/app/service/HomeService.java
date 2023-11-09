package com.github.manu156.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {

    @Autowired
    private LibraryService libraryService;

    public List<String> getMyBooks(Long userId) {
        return libraryService.getMyBooks(userId);
    }

    public List<String> getSuggestions(Long userId) {
        List<String> currentBooks = getMyBooks(userId);
        List<String> pastBookIds = libraryService.getPastBookIds(userId);
        return libraryService.getSuggestions(currentBooks, pastBookIds);
    }
}
