package br.com.aceleraprogramador.gerenciamento_pedidos.security;

import br.com.aceleraprogramador.gerenciamento_pedidos.model.UserInfoEntity;
import br.com.aceleraprogramador.gerenciamento_pedidos.repository.UserInfoRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
@Slf4j
public class InitialUserInfo implements CommandLineRunner {

    private final PasswordEncoder passwordEncoder;
    private final UserInfoRepository userInfoRepo;

    @Override
    public void run(String... args) throws Exception {
        UserInfoEntity manager = new UserInfoEntity();
        manager.setUserName("Manager");
        manager.setPassword(passwordEncoder.encode("password"));
        manager.setRoles("ROLE_MANAGER");
        manager.setEmailId("manager@manager.com");

        UserInfoEntity admin = new UserInfoEntity();
        admin.setUserName("Admin");
        admin.setPassword(passwordEncoder.encode("password"));
        admin.setRoles("ROLE_ADMIN");
        admin.setEmailId("admin@admin.com");

        UserInfoEntity user = new UserInfoEntity();
        user.setUserName("User");
        user.setPassword(passwordEncoder.encode("password"));
        user.setRoles("ROLE_USER");
        user.setEmailId("user@user.com");

        userInfoRepo.saveAll(List.of(manager, admin, user));

        List<UserInfoEntity> users = userInfoRepo.findAll();

        log.info("ok");
    }
}