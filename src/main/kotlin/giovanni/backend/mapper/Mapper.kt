package giovanni.backend.mapper

import giovanni.backend.dto.CustomerResponse
import giovanni.backend.dto.EyeConfigResponse
import giovanni.backend.dto.GlassesConfigResponse
import giovanni.backend.entity.Customer
import giovanni.backend.entity.EyeConfig
import giovanni.backend.entity.GlassesConfig

fun GlassesConfig.toDto() = GlassesConfigResponse(
    id = id!!,
    createdAt = createdAt,
    note = note,
    eyeConfigs = eyeConfigs.map { it.toDto() }
)

fun EyeConfig.toDto() = EyeConfigResponse(
    id = id!!,
    side = side,
    sph = sph,
    cyl = cyl,
    achse = achse,
    pd = pd,
    prism = prism
)

fun Customer.toDto() = CustomerResponse(
    id = id!!,
    geschlecht = geschlecht,
    geburtstag = geburtstag,
    familienname = familienname,
    vorname = vorname,
    anschrift = anschrift,
    telefon = telefon,
    email = email,
    glassesConfigs = glassesConfigs.map { it.toDto()}
)