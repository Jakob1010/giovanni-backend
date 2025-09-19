package giovanni.backend.mapper

import giovanni.backend.dto.CustomerRequest
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
    eyes = eyeConfigs.map { it.toDto() }
)

fun EyeConfig.toDto() = EyeConfigResponse(
    id = id,
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


fun CustomerRequest.toEntity(): Customer {
    val customer = Customer(
        geschlecht = this.geschlecht,
        geburtstag = this.geburtstag,
        familienname = this.familienname,
        vorname = this.vorname,
        anschrift = this.anschrift,
        telefon = this.telefon,
        email = this.email
    )

    this.glassesConfigs?.forEach { gcReq ->
        gcReq.eyes?.let { if (it.size > 2) throw IllegalArgumentException("A glasses config may have at most 2 eye configs") }

        val gc = GlassesConfig(
            customer = customer,
            note = gcReq.note
        )

        gcReq.eyes?.forEach { eyeReq ->
            val eye = EyeConfig(
                side = eyeReq.side,
                sph = eyeReq.sph?.toDouble(),
                cyl = eyeReq.cyl?.toDouble(),
                achse = eyeReq.achse,
                pd = eyeReq.pd?.toDouble(),
                prism = eyeReq.prism?.toDouble(),
                glassesConfig = gc
            )
            gc.eyeConfigs.add(eye)
        }

        customer.glassesConfigs.add(gc)
    }

    return customer
}