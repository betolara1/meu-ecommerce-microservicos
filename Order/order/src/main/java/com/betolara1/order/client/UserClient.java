package com.betolara1.order.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.cloud.openfeign.FeignClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@FeignClient(name = "user-client", url = "http://user-ms:8080")
public interface UserClient {
    @CircuitBreaker(name = "userServiceCB", fallbackMethod = "defaultUser")
    @GetMapping("/users/{id}")
    UserDTO getUserById(@PathVariable Long id);

    default UserDTO defaultUser(Long id, Throwable t) {
        UserDTO user = new UserDTO();
        user.setId(id);
        user.setName("Usuário Temporário (Modo Offline)");
        return user;
    }
}
