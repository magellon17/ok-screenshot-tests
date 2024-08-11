package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.comparison.PointsMarkupPolicy;

import java.awt.*;

public class ScreenshotComparer {

    private static final Logger log = LoggerFactory.getLogger(ScreenshotComparer.class);

    private static final int DIFF_SIZE_TRIGGER = 30;

    public static boolean compareScreenshotsAndSaveDiffToFile(Screenshot reference, Screenshot actual, String pathToDiffImg) {
        log.info("Отправляем запрос на получение показателя moderators, не имея необходимых прав");
        ImageDiff diff = new ImageDiffer()
                .withDiffMarkupPolicy(new PointsMarkupPolicy().withDiffColor(Color.BLUE))
                .makeDiff(reference, actual)
                .withDiffSizeTrigger(DIFF_SIZE_TRIGGER);
        ScreenshotUtils.saveScreenshotToFile(diff.getMarkedImage(), pathToDiffImg);
        log.info("Сохранил скриншот");
        return diff.hasDiff();
    }
}
