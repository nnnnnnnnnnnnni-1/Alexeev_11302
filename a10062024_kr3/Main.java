package a10062024_kr3;

public class Main {
    public static void main(String[] args) {

        BankAccount account = new BankAccount(1000);

        Thread client1 = new Thread(new Client("Клиент1", account));
        Thread client2 = new Thread(new Client("Клиент2", account));
        Thread client3 = new Thread(new Client("Клиент3", account));

        client1.start();
        client2.start();
        client3.start();

        try {
            client1.join();
            client2.join();
            client3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Все операции завершены.");
    }
}
