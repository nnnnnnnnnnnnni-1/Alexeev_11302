package HomeWork5;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import static HomeWork5.FileDownloader.*;
public class DownloadingThread implements Runnable{
    private final String fileUrl;
    private final String savePath;
    private static boolean isFinished;
    public DownloadingThread(String fileUrl, String savePath) {
        this.fileUrl = fileUrl;
        this.savePath = savePath;
    }
    public boolean getStatus(){
        return isFinished;
    }
    @Override
    public void run(){
        isFinished = false;
        synchronized (FileDownloader.class) {
            while (activeThreads >= MAX_THREADS) {
                try {
                    System.out.println("Все потоки заняты, файл в ожидании");
                    FileDownloader.class.wait();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
            activeThreads++;
        }
        URL url = null;
        try {
            url = new URL(fileUrl);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            InputStream inputStream = new BufferedInputStream(url.openStream());
            FileOutputStream fileOutputStream = new FileOutputStream(savePath + "\\" + url.getFile().split("/")[url.getFile().split("/").length - 1]);
            int len = connection.getContentLength();
            byte[] buffer = new byte[connection.getContentLength()];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }

            fileOutputStream.close();
            inputStream.close();
            connection.disconnect();

            System.out.println("File downloaded successfully.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            synchronized (FileDownloader.class) {
                activeThreads--;
                FileDownloader.class.notify();
            }
        }
        isFinished = true;
    }
}