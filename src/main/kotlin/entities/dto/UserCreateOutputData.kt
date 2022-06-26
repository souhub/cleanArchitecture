package entities.dto

import java.time.LocalDateTime

data class UserCreateOutputData(
    val userId: String,
    val created: LocalDateTime,
)
