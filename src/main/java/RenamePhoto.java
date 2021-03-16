import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Objects;

public class RenamePhoto {

    public static final String DIRECTORY_PATH = System.getProperty("user.home") + "/Downloads/archive";

    public static void main(String[] args) throws IOException {
        File directory = new File(DIRECTORY_PATH);
        String year;
        String month;
        String day;
        String hour;
        String minute;
        String second;
        String fileName;
        LocalDateTime newFileDateTime;
        for (File file : Objects.requireNonNull(directory.listFiles())) {
            fileName = file.getName();
            year = fileName.substring(4, 8);
            month = fileName.substring(8, 10);
            day = fileName.substring(10, 12);
            hour = fileName.substring(13, 15);
            minute = fileName.substring(15, 17);
            second = fileName.substring(17, 19);
            newFileDateTime = LocalDateTime.of(
                    Integer.parseInt(year),
                    Integer.parseInt(month),
                    Integer.parseInt(day),
                    Integer.parseInt(hour),
                    Integer.parseInt(minute),
                    Integer.parseInt(second));
            Files.setLastModifiedTime(file.toPath(), FileTime.from(newFileDateTime.toInstant(ZoneOffset.UTC)));
        }
    }
}
