package giovanni.backend.dto

import java.time.LocalDate

data class CustomerRequest(
    val geschlecht: String,
    val geburtstag: LocalDate,
    val familienname: String,
    val vorname: String,
    val anschrift: String,
    val telefon: String?,
    val email: String?,
    val glassesConfigs: List<GlassesConfigRequest>? = null
)