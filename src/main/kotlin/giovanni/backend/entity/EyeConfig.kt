package giovanni.backend.entity

import jakarta.persistence.*
import java.util.*

@Entity
@Table(
    name = "eye_configs",
    uniqueConstraints = [
        UniqueConstraint(columnNames = ["glasses_config_id", "side"])
    ]
)
data class EyeConfig(
    @Id
    val id: UUID = UUID.randomUUID(),

    @Enumerated(EnumType.STRING)
    val side: EyeSide? = null,

    val sph: Double? = null,

    val cyl: Double? = null,

    val achse: Int? = null,

    val pd: Double? = null,

    val prism: Double? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "glasses_config_id", nullable = false)
    val glassesConfig: GlassesConfig
)

enum class EyeSide {
    LEFT, RIGHT
}