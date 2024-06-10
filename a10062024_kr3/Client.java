package a10062024_kr3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Client extends Thread{
    private final String name;
    private final BankAccount account;
    private final Random random;
    public Client(String name, BankAccount account) {
        this.name = name;
        this.account = account;
        this.random = new Random();
    }
    private void addMoney(int sum) {
        try{
            account.addMoney(sum);
            writeInJournal(name, "пополнение", sum, account.getBalance());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void subtractMoney(int sum) {
        try{
            account.subtractMoney(sum);
            writeInJournal(name, "снятие", sum, account.getBalance());
        } catch (NotEnoughMoneyException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void run(){
        for (int i = 0; i < 20; i++) {
            int sum = random.nextInt(1000) + 1;

            synchronized(account) {
                if (random.nextBoolean()) {
                    addMoney(sum);
                } else {
                    subtractMoney(sum);
                }
            }
            try {
                Thread.sleep(random.nextInt(1000)); //сделал так, чтобы один поток не захватил управление на всё время работы программы
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
    private void writeInJournal(String clientName, String operation, int sum, int balance) {
        try (FileWriter writer = new FileWriter("src\\a10062024_kr3\\journal.txt", true)) {
            writer.write(clientName + ", " + operation + ", сумма: " + sum + ", баланс: " + balance + "\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
