package giovanni.backend.dto

import java.util.UUID

data class GlassesConfigResponse(
    val id: UUID,
    val createdAt: java.time.Instant,
    val note: String?,
    val eyes: List<EyeConfigResponse>
)