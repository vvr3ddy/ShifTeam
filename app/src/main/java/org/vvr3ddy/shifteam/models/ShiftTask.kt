package org.vvr3ddy.shifteam.models

import java.time.LocalDateTime
import java.util.UUID

data class ShiftTask(
    val id: UUID = UUID.randomUUID(),
    val shiftId: Long,
    val taskId: UUID,
    val status: TaskStatus,
    val taskUpdateTime: LocalDateTime,
    val taskStartTime: LocalDateTime,
    val taskEndTime: LocalDateTime
)

enum class TaskStatus {
    PENDING,
    IN_PROGRESS,
    COMPLETED
}
