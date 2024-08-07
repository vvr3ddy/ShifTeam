package org.vvr3ddy.shifteam.models

import java.util.UUID

data class Location(
    val id: UUID = UUID.randomUUID(),
    val locationId: Long,
    val siteName: String,
    val longitude: Double,
    val latitude: Double
)
