package giovanni.backend.dto

import java.time.LocalDate

data class CustomerRequest(
    val geschlecht: String? = null,
    val geburtstag: LocalDate? = null,
    val familienname: String? = null,
    val vorname: String? = null,
    val anschrift: String? = null,
    val telefon: String? = null,
    val email: String? = null,
    val glassesConfigs: List<GlassesConfigRequest>? = null
)