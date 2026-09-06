package com.example.instadev.data.repository

import com.example.instadev.data.response.UserResponse
import com.example.instadev.data.response.toDomain
import com.example.instadev.domain.entity.UserEntity
import com.example.instadev.domain.repository.AuthRepository

class AuthRepositoryImpl() : AuthRepository {
    override fun doLogin(user: String, password: String): UserEntity {
        val userResponse: UserResponse = UserResponse("", "", "", 10, listOf(""), 0)
        return userResponse.toDomain()
    }
}