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

    @Column(nullable = false)
    val geschlecht: String,

    @Column(nullable = false)
    val geburtstag: LocalDate,

    @Column(nullable = false)
    val familienname: String,

    @Column(nullable = false)
    val vorname: String,

    @Column(nullable = false)
    val anschrift: String,

    val telefon: String?,
    val email: String?,

    @OneToMany(
        mappedBy = "customer",
        cascade = [CascadeType.PERSIST, CascadeType.MERGE],
        orphanRemoval = true
    )
    val glassesConfigs: MutableList<GlassesConfig> = mutableListOf()
)
