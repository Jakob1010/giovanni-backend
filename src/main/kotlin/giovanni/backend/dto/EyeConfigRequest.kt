package giovanni.backend.dto

data class EyeConfigRequest(
    val side: Char, // 'R' or 'L'
    val sph: String?,
    val cyl: String?,
    val achse: String?,
    val pd: String?,
    val prism: String?
)