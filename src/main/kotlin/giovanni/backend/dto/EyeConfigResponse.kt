package giovanni.backend.dto

import java.util.UUID

data class EyeConfigResponse(
    val id: UUID,
    val side: Char,
    val sph: String?,
    val cyl: String?,
    val achse: String?,
    val pd: String?,
    val prism: String?
)