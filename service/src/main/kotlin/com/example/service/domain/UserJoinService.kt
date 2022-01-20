package com.example.service.domain

import com.example.entity.domain.User
import com.example.entity.repository.UserRepository
import com.example.port.UserJoinPort
import org.springframework.stereotype.Service

@Service
class UserJoinService(
  private val userRepository: UserRepository
) : UserJoinPort {

  override fun join() {
    val user = User(
      email = "roach@naver.com"
    );

    userRepository.save(user)

  }

}