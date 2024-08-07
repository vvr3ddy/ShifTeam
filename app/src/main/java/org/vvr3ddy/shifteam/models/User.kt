package org.vvr3ddy.shifteam.models

import java.util.UUID

data class User(
    val id: UUID = UUID.randomUUID(),
    val baseLocation: Long,
    val managerId: Long,
    val name: String,
    val email: String,
    val password: String,
    val role: Role
)

enum class Role {
    ADMIN,
    MANAGER,
    EMPLOYEE
}