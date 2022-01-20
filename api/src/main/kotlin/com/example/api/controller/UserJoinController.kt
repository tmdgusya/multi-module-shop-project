package com.example.api.controller

import com.example.port.UserJoinPort
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserJoinController(
  private val userJoinPort: UserJoinPort
) {

  @GetMapping("/users")
  fun hello() {
    userJoinPort.join()
  }

}