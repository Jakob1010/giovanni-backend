package giovanni.backend.dto

data class GlassesConfigRequest(
    val note: String?,
    val eyes: List<EyeConfigRequest> = emptyList()
)