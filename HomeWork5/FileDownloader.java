package HomeWork5;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
//"src\\HomeWork5"
//"https://i.pinimg.com/564x/7f/52/9f/7f529fb9d45079d930c0b24e86ac28ff.jpg"
public class FileDownloader {
    static final int MAX_THREADS = 8;
    volatile static int activeThreads = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean f = false;
        while(true) {
            System.out.println("Введите URL или введите status чтобы узнать загружен ли последний файл");
            String url = sc.nextLine();
            while (url.equals("status")){
                if (f){
                    System.out.println("100");
                    break;
                } else {
                    System.out.println("0");
                }
                System.out.println("Введите URL или введите status чтобы узнать загружен ли последний файл");
                url = sc.nextLine();
            }
            System.out.println("Введите путь к папке, куда будет загружен файл");
            String savePath = sc.nextLine();
            if (url.equals("exit") || savePath.equals("exit")){
                break;
            }
            f = downloadFile(url, savePath);
        }
    }
    private static boolean downloadFile(String fileUrl, String savePath) {
        DownloadingThread downloadingThread = new DownloadingThread(fileUrl, savePath);
        Thread thread = new Thread(downloadingThread);
        thread.start();
        return downloadingThread.getStatus();
    }
}

