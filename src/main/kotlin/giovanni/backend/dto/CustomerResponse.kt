package giovanni.backend.dto

import java.time.LocalDate
import java.util.UUID

data class CustomerResponse(
    val id: UUID,
    val geschlecht: String,
    val geburtstag: LocalDate,
    val familienname: String,
    val vorname: String,
    val anschrift: String,
    val telefon: String?,
    val email: String?,
    val glassesConfigs: List<GlassesConfigResponse>
)