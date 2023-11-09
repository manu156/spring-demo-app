package com.github.manu156.app.service;

import com.github.manu156.app.CommonUtil;
import com.github.manu156.app.repository.BookRepository;
import com.github.manu156.app.repository.BorrowingRepository;
import com.github.manu156.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibraryService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BorrowingRepository borrowingRepository;

    @Autowired
    private CalendarService calendarService;


    public List<String> getMyBooks(Long userId) {
        List<String> books = new ArrayList<>();
        List<String> roles = userRepository.getUserRoles();
        for (String role : roles) {
            books.addAll(borrowingRepository.getBooksForUserAndRole(userId, role));
        }

        bookRepository.addBasicBookDetails(books);
        calendarService.addBookBorrowingSchedule(books);

        return books;
    }

    public List<String> getPastBookIds(Long userId) {
        List<String> books = new ArrayList<>();
        List<String> roles = userRepository.getUserRoles();
        for (String role : roles) {
            books.addAll(borrowingRepository.getPastBorrowedBooks(userId, role));
        }

        return books;
    }

    public List<String> getSuggestions(List<String> currentBooks, List<String> pastBookIds) {
        // do analysis
        List<String> allBooks = new ArrayList<>(currentBooks);
        allBooks.addAll(pastBookIds);
        return CommonUtil.getRandomListOfStrings(allBooks);
    }
}
