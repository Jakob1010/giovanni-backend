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
    @GeneratedValue
    val id: UUID? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "glasses_config_id", nullable = false)
    val glassesConfig: GlassesConfig,

    @Column(nullable = false, length = 1)
    val side: Char, // 'R' or 'L'

    val sph: String?,
    val cyl: String?,
    val achse: String?,
    val pd: String?,
    val prism: String?
)