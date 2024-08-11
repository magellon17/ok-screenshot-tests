package utils;

import ru.yandex.qatools.ashot.Screenshot;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ScreenshotUtils {

    public static Screenshot getScreenshotByPath(String path) {
        try {
            return new Screenshot(ImageIO.read(new File(path)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isScreenshotFound(String path) {
        return Files.exists(Paths.get(path));
    }

    public static void saveScreenshotToFile(BufferedImage screenshot, String path) {
        try {
            ImageIO.write(screenshot, "PNG", new File(path));
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
