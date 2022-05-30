package springbikedemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springbikedemo.bikerental.controller.BikeController;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class BikeControllerIT {

    @Autowired
    BikeController controller;


    @Test
    void testGetUserIds() {
        Set<String> result = controller.getUserIds();
        assertThat(result).contains("US3434");
    }

    @Test
    void testGetUserIdsOther() {
        Set<String> result = controller.getUserIds();
        assertThat(result).doesNotContain("US34ddddddd4");
    }

}