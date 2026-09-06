package com.example.instadev.domain.usecase

import com.example.instadev.domain.repository.AuthRepository
import javax.inject.Inject

class Login @Inject constructor(val authRepository: AuthRepository) {
    operator fun invoke(user: String, password: String) {
        if(user.contains("@hotmail.com")) {
            return
        }
        val res = authRepository.doLogin(user, password)
    }
}