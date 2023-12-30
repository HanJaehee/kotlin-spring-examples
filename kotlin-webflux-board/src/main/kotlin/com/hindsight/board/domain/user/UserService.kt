package com.hindsight.board.domain.user

import com.hindsight.board.exception.GlobalException
import com.hindsight.board.exception.GlobalMessage
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(private val userRepository: UserRepository) {

    @Transactional
    suspend fun create(createDto: UserDto.Create) {
        if (!userRepository.existsByUserId(userId = createDto.userId)) {
            throw GlobalException(globalMessage = GlobalMessage.DUPLICATE_USER_ID)
        }

        userRepository.save(User(createDto = createDto))
    }

    // 로그인 실패에 대한 처리 등은 했다고 치자..
    suspend fun login(loginDto: UserDto.Login): User =
        userRepository.findUserIdAndPassword(userId = loginDto.userId, password = loginDto.password)
            ?: throw GlobalException(globalMessage = GlobalMessage.FAIL_LOGIN)

    suspend fun findUserById(id: Long): User =
        userRepository.findById(id = id) ?: throw Exception("hiyo")

}
