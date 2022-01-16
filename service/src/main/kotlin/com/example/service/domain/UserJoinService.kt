package com.example.service.domain

import com.example.entity.domain.User
import com.example.entity.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserJoinService(
  private val userRepository: UserRepository
) {

  fun hello(): String {
    val user = User(
      email = "roach@naver.com"
    );

    userRepository.save(user)

    return "Hello"
  }

}