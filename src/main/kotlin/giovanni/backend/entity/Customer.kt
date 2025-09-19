package giovanni.backend.entity

import jakarta.persistence.*
import java.time.LocalDate
import java.util.UUID

@Entity
@Table(name = "customers")
data class Customer(
    @Id
    @GeneratedValue
    val id: UUID? = null,
    var geschlecht: String? = null,
    var geburtstag: LocalDate? = null,
    var familienname: String? = null,
    var vorname: String? = null,
    var anschrift: String? = null,
    var telefon: String? = null,
    var email: String? = null,

    @OneToMany(
        mappedBy = "customer",
        cascade = [CascadeType.ALL, CascadeType.MERGE],
        orphanRemoval = true
    )
    val glassesConfigs: MutableList<GlassesConfig> = mutableListOf()
) {
    // for JPA
    constructor() : this(
        geschlecht = "",
        geburtstag = LocalDate.MIN,
        familienname = "",
        vorname = "",
        anschrift = "",
        telefon = null,
        email = null
    )
}