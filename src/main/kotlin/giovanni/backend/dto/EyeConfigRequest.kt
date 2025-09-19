package giovanni.backend.dto

import giovanni.backend.entity.EyeSide
import java.math.BigDecimal

data class EyeConfigRequest(
    val side: EyeSide?=null,
    val sph: BigDecimal?=null,   // NUMERIC(4,2)
    val cyl: BigDecimal?=null,   // NUMERIC(4,2)
    val achse: Int?=null,
    val pd: BigDecimal?=null,    // NUMERIC(4,1)
    val prism: BigDecimal?=null // NUMERIC(4,2)
)