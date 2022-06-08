package com.kul.zaliczenie.printer;

import com.kul.zaliczenie.model.Book;
import com.kul.zaliczenie.model.LoanedBooks;
import com.kul.zaliczenie.service.BookService;
import com.kul.zaliczenie.service.LoanedBookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class MainPrinter {

    private final Scanner scanner = new Scanner(System.in);
    private final BookService bookService;
    private final LoanedBookService loanedBookService;

    public void process() {
        System.out.println("Witaj w bibliotece");
        int input;
        do {
            printMenu();
            input = processUserInput();
        } while (input != 7);
    }

    private int processUserInput() {
        int input;
        input = Integer.parseInt(scanner.nextLine());
        switch (input) {
            case 1:
                printBooks();
                System.out.println("---");
                break;
            case 2:
                addBook();
                System.out.println("---");
                break;
            case 3:
                deleteBook();
                System.out.println("---");
                break;
            case 4:
                printLoans();
                System.out.println("---");
                break;
            case 5:
                loanBook();
                System.out.println("---");
                break;
            case 6:
                returnBook();
                System.out.println("---");
                break;
            case 7:
                break;
            default:
                System.out.println("Nie ma takiej opcji.");
        }
        return input;
    }

    private void returnBook() {
        System.out.println("Podaj ID wypożyczenia");
        printLoans();
        String id = scanner.nextLine();
        loanedBookService.returnBook(Long.parseLong(id));
    }

    private void loanBook() {
        System.out.println("Podaj ID książki, którą chcesz wypożyczyć");
        printBooks();
        String id = scanner.nextLine();
        System.out.println("Podaj dzisiajszą datę");
        String date = scanner.nextLine();
        loanedBookService.add(new LoanedBooks(Long.parseLong(id), date));
    }

    private void printLoans() {
        List<String> loans = loanedBookService.loanedBooks()
                .stream()
                .map(LoanedBooks::toString)
                .collect(Collectors.toList());

        for (int i = 0; i < loans.size(); i++) {
            System.out.println((i + 1) + ". " + loans.get(i));
        }
    }

    private void deleteBook() {
        System.out.println("Podaj ID ksiażki, którą chcesz usunąć");
        printBooks();
        String id = scanner.nextLine();
        bookService.removeBook(Long.parseLong(id));

    }

    private void addBook() {
        System.out.println("Dodaj książkę:");
        System.out.println("Podaj tytul");
        String title = scanner.nextLine();
        System.out.println("Podaj autora");
        String author = scanner.nextLine();
        System.out.println("Podaj rok wydania");
        String publishYear = scanner.nextLine();
        bookService.add(new Book(title, author, publishYear));
    }

    private void printBooks() {
        List<String> books = bookService.loadList()
                .stream()
                .map(Book::toString)
                .collect(Collectors.toList());

        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i));
        }
    }

    private void printMenu() {
        System.out.println("Co chcesz zrobić? ");
        System.out.println("1. Wyświetl książki");
        System.out.println("2. Dodaj książkę");
        System.out.println("3. Usuń książkę");
        System.out.println("4. Wyświetl wypożyczenia");
        System.out.println("5. Wypożycz książkę");
        System.out.println("6. Oddaj książkę");
    }
}
