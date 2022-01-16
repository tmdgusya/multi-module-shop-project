package com.example.api.controller

import com.example.service.domain.UserJoinService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserJoinController(
  private val userJoinService: UserJoinService
) {

  @GetMapping("/hello")
  fun hello(): String {
    return userJoinService.hello()
  }

}