package com.hindsight.board.domain.user

import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    suspend fun create(createDto: UserDto.Create): User =
        userRepository.save(User(createDto = createDto))

    suspend fun findUserById(id: Long): User =
        userRepository.findById(id = id) ?: throw Exception("hiyo")

}
