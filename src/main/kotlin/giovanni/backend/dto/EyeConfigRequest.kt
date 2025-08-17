package giovanni.backend.dto

import giovanni.backend.entity.EyeSide
import java.math.BigDecimal

data class EyeConfigRequest(
    val side: EyeSide,
    val sph: BigDecimal,   // NUMERIC(4,2)
    val cyl: BigDecimal,   // NUMERIC(4,2)
    val achse: Int,
    val pd: BigDecimal,    // NUMERIC(4,1)
    val prism: BigDecimal? // NUMERIC(4,2)
)