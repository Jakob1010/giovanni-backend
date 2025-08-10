package giovanni.backend.dto

import giovanni.backend.entity.EyeSide
import java.util.UUID

data class EyeConfigResponse(
    val id: UUID,
    val side: EyeSide,
    val sph: Double,
    val cyl: Double,
    val achse: Int,
    val pd: Double,
    val prism: Double?
)