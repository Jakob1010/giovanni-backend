package giovanni.backend.entity

import giovanni.backend.dto.EyeConfigResponse
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

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    val side: EyeSide,

    @Column(nullable = false)
    val sph: Double,

    @Column(nullable = false)
    val cyl: Double,

    @Column(nullable = false)
    val achse: Int,

    @Column(nullable = false)
    val pd: Double,

    @Column
    val prism: Double? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "glasses_config_id", nullable = false)
    val glassesConfig: GlassesConfig
)

enum class EyeSide {
    LEFT, RIGHT
}