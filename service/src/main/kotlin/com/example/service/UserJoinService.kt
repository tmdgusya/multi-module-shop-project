package com.example.service

import com.example.entity.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserJoinService(
  val userRepository: UserRepository
) {

}