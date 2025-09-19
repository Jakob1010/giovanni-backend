package giovanni.backend.dto

import giovanni.backend.entity.EyeSide
import java.util.UUID

data class EyeConfigResponse(
    val id: UUID,
    val side: EyeSide? = null,
    val sph: Double? = null,
    val cyl: Double? = null,
    val achse: Int? = null,
    val pd: Double? = null,
    val prism: Double?
)