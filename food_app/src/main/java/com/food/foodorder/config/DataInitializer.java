package com.team11.foodorder.config;

import com.team11.foodorder.entity.Admin;
import com.team11.foodorder.entity.Customer;
import com.team11.foodorder.entity.Driver;
import com.team11.foodorder.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * DataInitializer — runs at startup and creates default users
 * using the real BCryptPasswordEncoder so passwords always match.
 * This replaces the password rows in data.sql to avoid hash mismatches.
 */
@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        // Only seed if no users exist yet
        if (userRepository.count() > 0) return;

        // Admin
        Admin admin = new Admin();
        admin.setName("Admin User");
        admin.setEmail("admin@demo.com");
        admin.setPassword(passwordEncoder.encode("admin"));
        admin.setPhone("9000000000");
        admin.setRole("ROLE_ADMIN");
        userRepository.save(admin);

        // Customer: Alice
        Customer alice = new Customer();
        alice.setName("Alice Kumar");
        alice.setEmail("alice@demo.com");
        alice.setPassword(passwordEncoder.encode("pass123"));
        alice.setPhone("9876543210");
        alice.setRole("ROLE_CUSTOMER");
        userRepository.save(alice);

        // Customer: Bob
        Customer bob = new Customer();
        bob.setName("Bob Sharma");
        bob.setEmail("bob@demo.com");
        bob.setPassword(passwordEncoder.encode("pass123"));
        bob.setPhone("9123456789");
        bob.setRole("ROLE_CUSTOMER");
        userRepository.save(bob);

        // Driver
        Driver driver = new Driver();
        driver.setName("Ravi Driver");
        driver.setEmail("ravi@demo.com");
        driver.setPassword(passwordEncoder.encode("pass123"));
        driver.setPhone("9111111111");
        driver.setRole("ROLE_DRIVER");
        userRepository.save(driver);

        System.out.println("✅ DataInitializer: default users created.");
    }
}
