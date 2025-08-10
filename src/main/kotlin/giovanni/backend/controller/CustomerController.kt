package giovanni.backend.controller

import giovanni.backend.dto.CustomerResponse
import giovanni.backend.dto.EyeConfigResponse
import giovanni.backend.dto.GlassesConfigResponse
import giovanni.backend.entity.EyeSide
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID

@RestController
@RequestMapping("/customers")
class CustomerController {

    @PostMapping
    fun addCustomer(@RequestBody customer: CustomerResponse): CustomerResponse {
        return customer.copy(id = UUID.randomUUID())
    }

    @PutMapping("/{id}")
    fun updateCustomer(
        @PathVariable id: UUID,
        @RequestBody customer: CustomerResponse
    ): CustomerResponse {
        return customer.copy(id = id)
    }

    @GetMapping
    fun getAllCustomers(
        @RequestParam(required = false) search: String?
    ): List<CustomerResponse> {
        val mockEyeConfig = EyeConfigResponse(
            id = UUID.randomUUID(),
            side = EyeSide.LEFT,
            sph = -1.5,
            cyl = -0.5,
            achse = 90,
            pd = 31.0,
            prism = null
        )

        val mockGlassesConfig = GlassesConfigResponse(
            id = UUID.randomUUID(),
            createdAt = Instant.now(),
            note = "Reading glasses",
            eyeConfigs = listOf(mockEyeConfig)
        )

        val mockCustomer = CustomerResponse(
            id = UUID.randomUUID(),
            geschlecht = "m",
            geburtstag = LocalDate.of(1990, 5, 12),
            familienname = "Doe",
            vorname = "John",
            anschrift = "123 Main St",
            telefon = "+43 123 4567",
            email = "john@example.com",
            glassesConfigs = listOf(mockGlassesConfig)
        )

        return listOf(mockCustomer)
    }
}