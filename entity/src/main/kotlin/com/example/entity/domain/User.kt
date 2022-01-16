package com.example.entity.domain

import javax.persistence.*

@Entity
class User(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var id: Long,

  @Column(name = "email", nullable = false)
  var email: String,
) {
}