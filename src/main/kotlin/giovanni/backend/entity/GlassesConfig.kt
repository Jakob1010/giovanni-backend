package giovanni.backend.entity

import jakarta.persistence.*
import java.time.Instant
import java.util.*

@Entity
@Table(name = "glasses_configs")
data class GlassesConfig(
    @Id
    @GeneratedValue
    val id: UUID? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    val customer: Customer,

    @Column(name = "created_at", nullable = false, updatable = false)
    val createdAt: Instant = Instant.now(),

    @Column(columnDefinition = "text")
    val note: String? = null,

    @OneToMany(
        mappedBy = "glassesConfig",
        cascade = [CascadeType.PERSIST, CascadeType.MERGE],
        orphanRemoval = true
    )
    val eyeConfigs: MutableList<EyeConfig> = mutableListOf()
)