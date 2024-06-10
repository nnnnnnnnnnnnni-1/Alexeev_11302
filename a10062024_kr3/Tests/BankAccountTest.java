package a10062024_kr3.Tests;

import a10062024_kr3.BankAccount;
import a10062024_kr3.NotEnoughMoneyException;
import jdk.management.resource.ResourceType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    private BankAccount mock;

    @BeforeEach
    void setUp() throws IOException {
        mock = new BankAccount(1000);
        Files.createFile(Paths.get("src\\a10062024_kr3\\Tests\\journal.txt"));
    }

    @AfterEach
    void tearDown() {
        try {
            Files.deleteIfExists(Paths.get("src\\a10062024_kr3\\Tests\\journal.txt"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testAdding() {
        mock.addMoney(500);
        assertTrue(mock.getBalance() > 1000);
        assertEquals(1500, mock.getBalance());
    }

    @Test
    void testSubstractMoney() throws NotEnoughMoneyException {
        mock.subtractMoney(500);
        assertTrue(mock.getBalance() < 1000);
        assertEquals(500, mock.getBalance());
    }


}