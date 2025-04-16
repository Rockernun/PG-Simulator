package com.pg.simulation.pg_simulation;

import com.pg.simulation.pg_simulation.domain.User;
import com.pg.simulation.pg_simulation.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @DisplayName("사용자 저장 및 조회 기능 테스트")
    @Test
    void UserRepositoryTest() {

        userRepository.deleteAll();

        // given
        User user = new User();
        user.setUsername("merchant1");
        user.setPassword("1234");
        user.setRole("MERCHANT");
        user.setMerchantName("테스트 가맹점");

        // when
        User savedUser = userRepository.save(user);
        User foundUser = userRepository.findById(savedUser.getId()).orElse(null);

        // then
        assertThat(foundUser).isNotNull();
        assertThat(foundUser.getUsername()).isEqualTo("merchant1");
        assertThat(foundUser.getMerchantName()).isEqualTo("테스트 가맹점");
    }
}
