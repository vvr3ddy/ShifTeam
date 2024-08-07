package org.vvr3ddy.shifteam.models

import java.time.LocalDateTime
import java.util.UUID

data class Shift(
    val id: UUID = UUID.randomUUID(),
    val shiftId: Long,
    val employeeId: Long,
    val managerId: Long,
    val locationId: Long,
    val startTime: LocalDateTime,
    val endTime: LocalDateTime,
    val status: ShiftStatus
)

enum class ShiftStatus {
    PENDING,
    APPROVED,
    REJECTED
}