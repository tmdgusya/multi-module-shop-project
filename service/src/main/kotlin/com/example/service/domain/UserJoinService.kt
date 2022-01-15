package com.example.service.domain

import com.example.entity.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserJoinService(
  val userRepository: UserRepository
) {

}