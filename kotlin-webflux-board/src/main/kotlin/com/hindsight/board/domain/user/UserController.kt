package com.hindsight.board.domain.user

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(private val userService: UserService) {

    @PostMapping
    suspend fun create(@RequestBody createDto: UserDto.Create): ResponseEntity<Unit> =
        userService.create(createDto).let {
            ResponseEntity
                .status(HttpStatus.CREATED)
                .build()
        }

    @PostMapping("/login")
    suspend fun login(@RequestBody loginDto: UserDto.Login): ResponseEntity<User> =
        userService.login(loginDto = loginDto).let {
            ResponseEntity
                .status(HttpStatus.OK)
                .body(it)
        }

    @GetMapping("/{userId}")
    suspend fun findUserById(@PathVariable userId: Long): ResponseEntity<User> =
        ResponseEntity
            .ok()
            .body(userService.findUserById(id = userId))
}