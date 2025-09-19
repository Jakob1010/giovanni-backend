package giovanni.backend.dto

import java.time.LocalDate
import java.util.UUID

data class CustomerResponse(
    val id: UUID,
    val geschlecht: String? = null,
    val geburtstag: LocalDate? = null,
    val familienname: String? = null,
    val vorname: String? = null,
    val anschrift: String? = null,
    val telefon: String? = null,
    val email: String? = null,
    val glassesConfigs: List<GlassesConfigResponse>
)