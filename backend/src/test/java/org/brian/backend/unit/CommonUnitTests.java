package org.brian.backend.unit;

import org.assertj.core.api.SoftAssertions;
import org.brian.backend.exception.ExceptionLogger;
import org.brian.backend.exception.ModuleException;
import org.brian.dao.ext.entity.Guestbook;
import org.brian.dao.ext.mapper.GuestbookMapper;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class CommonUnitTests {

    @Test
    public void URI_solution() throws URISyntaxException, IOException {
        String filePath = "C:\\Users\\Brian\\Desktop\\講稿.txt";

        filePath = "file:" + filePath.replace("\\", "/");
        filePath = new URI(filePath).normalize().getSchemeSpecificPart();
        filePath = filePath.replace("/", File.separator);
        File file = new File(filePath);
        String canonicalPath = file.getCanonicalPath();
        boolean actual = filePath.equals(canonicalPath);

        assertThat(actual).isTrue();
    }

    @Test
    public void URI_solution_WrongInput() throws URISyntaxException, IOException {
        String filePath = "C:\\Users\\Brian\\Desktop\\..\\講稿.txt";

        filePath = "file:" + filePath.replace("\\", "/");
        filePath = new URI(filePath).normalize().getSchemeSpecificPart();
        filePath = filePath.replace("/", File.separator);
        File file = new File(filePath);
        String canonicalPath = file.getCanonicalPath();
        boolean actual = filePath.equals(canonicalPath);

        assertThat(actual).isFalse();
    }

    @Test
    public void Path_append() throws IOException {
        String userPath = "C:\\Users\\Brian";
        String desktop = "Desktop";
        String fileName = "講稿.txt";

        getFilePathShouldSuccess(userPath, desktop, fileName);
    }

    private void getFilePathShouldSuccess(String userPath, String desktop, String fileName) throws IOException {
        Path path = Paths.get(userPath, desktop, fileName);
        File file = path.toFile();
        String canonicalPath = file.getCanonicalPath();
        boolean actual = path.toString().equals(canonicalPath);

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(path.getRoot().toString()).isEqualTo("C:\\");
        softAssertions.assertThat(path.getParent().toString()).isEqualTo("C:\\Users\\Brian\\Desktop");
        softAssertions.assertThat(path.toString()).isEqualTo("C:\\Users\\Brian\\Desktop\\講稿.txt");
        softAssertions.assertThat(file.getPath()).isEqualTo("C:\\Users\\Brian\\Desktop\\講稿.txt");
        softAssertions.assertThat(actual).isTrue();
        softAssertions.assertAll();
    }

    @Test
    public void Path_append_() throws IOException {
        String userPath = "C:\\Users\\Brian";
        String desktop = "\\Desktop/";
        String fileName = "///講稿.txt";

        getFilePathShouldSuccess(userPath, desktop, fileName);
    }

    @Test
    public void Path_append_Error() throws IOException {
        String userPath = "C:\\Users\\Brian";
        String desktop = "\\Desktop/";
        String fileName = "../講稿.txt";

        Path path = Paths.get(userPath, desktop, fileName);
        File file = path.toFile();
        String canonicalPath = file.getCanonicalPath();
        boolean actual = path.toString().equals(canonicalPath);

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(path.getRoot().toString()).isEqualTo("C:\\");
        softAssertions.assertThat(path.getParent().toString()).isEqualTo("C:\\Users\\Brian\\Desktop\\..");
        softAssertions.assertThat(path.toString()).isEqualTo("C:\\Users\\Brian\\Desktop\\..\\講稿.txt");
        softAssertions.assertThat(file.getPath()).isEqualTo("C:\\Users\\Brian\\Desktop\\..\\講稿.txt");
        softAssertions.assertThat(actual).isFalse();
        softAssertions.assertAll();
    }

    @Test
    public void Path_solution() {

    }

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void logCommonException() {
        try {
            throwException();
        } catch (Exception e) {
            ExceptionLogger.getInstance().info(logger, e.getMessage(), e, true);
        }
    }

    private void throwException() throws Exception {
        throw new Exception("測試用Exception");
    }

    @Test
    public void logModuleException_Enum() {
        try {
            throwModuleException_Enum();
        } catch (ModuleException e) {
            e.error(logger, e.getMessage(), true, new HashMap<>());
        }
    }

    private void throwModuleException_Enum() throws ModuleException {
        throw new ModuleException(ModuleException.Exceptions.SequenceIsNotExist);
    }

}
