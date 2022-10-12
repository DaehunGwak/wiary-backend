package io.wiary.wiarybackend.profile;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@ActiveProfiles("local")
public class ProfileTest {

    @Value("${test-value.something}")
    private String something;

    @Value("${test-value.something-sec}")
    private String somethingSecurity;

    @Test
    public void 프로필그룹_밸류_테스트() {
        assertThat(something).isEqualTo("something");
        assertThat(somethingSecurity).isEqualTo("something-sec");
    }
}
