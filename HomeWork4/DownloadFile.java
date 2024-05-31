package HomeWork4;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadFile {
    public static void main(String[] args) {
        String fileUrl = "https://i.pinimg.com/564x/3d/a5/9e/3da59e02d2f276f9404ea9d187ec8b33.jpg";
        String savePath = "C:\\Users\\admin\\IdeaProjects\\informatics3\\src\\ClassWork5\\image.jpg";

        try {
            URL url = new URL(fileUrl);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            InputStream inputStream = new BufferedInputStream(url.openStream());
            FileOutputStream fileOutputStream = new FileOutputStream(savePath);
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
        } catch (Exception e) {
            System.out.println("Error downloading file: " + e.getMessage());
        }
    }
}
