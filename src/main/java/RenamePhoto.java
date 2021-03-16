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
        String fileName;
        for (File file : Objects.requireNonNull(new File(DIRECTORY_PATH).listFiles())) {
            fileName = file.getName();
            Files.setLastModifiedTime(file.toPath(), FileTime.from(
                    LocalDateTime.of(
                            Integer.parseInt(fileName.substring(4, 8)),
                            Integer.parseInt(fileName.substring(8, 10)),
                            Integer.parseInt(fileName.substring(10, 12)),
                            Integer.parseInt(fileName.substring(13, 15)),
                            Integer.parseInt(fileName.substring(15, 17)),
                            Integer.parseInt(fileName.substring(17, 19))).toInstant(ZoneOffset.UTC)
            ));
        }
    }
}
