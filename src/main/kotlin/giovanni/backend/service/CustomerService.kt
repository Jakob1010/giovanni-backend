package giovanni.backend.service

import giovanni.backend.dto.CustomerRequest
import giovanni.backend.dto.CustomerResponse
import giovanni.backend.entity.Customer
import giovanni.backend.entity.EyeConfig
import giovanni.backend.entity.GlassesConfig
import giovanni.backend.mapper.toDto
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import giovanni.backend.repository.CustomerRepository


@Service
class CustomerService(
    private val customerRepository: CustomerRepository
) {
    private val log = LoggerFactory.getLogger(CustomerService::class.java)

    @Transactional
    fun addCustomer(request: CustomerRequest): CustomerResponse {
        log.info("Adding new customer: {} {}", request.vorname, request.familienname)

        val customer = Customer(
            geschlecht = request.geschlecht,
            geburtstag = request.geburtstag,
            familienname = request.familienname,
            vorname = request.vorname,
            anschrift = request.anschrift,
            telefon = request.telefon,
            email = request.email
        )

        // iterate over all glasses configs
        request.glassesConfigs?.forEach { gcReq ->
            gcReq.eyes?.size?.let {
                if (it > 2) {
                    throw IllegalArgumentException("A glasses config may have at most 2 eye configs")
                }
            }

            val glassesConfig = GlassesConfig(
                customer = customer,
                note = gcReq.note
            )

            gcReq.eyes?.forEach { eyeReq ->
                val eyeConfig = EyeConfig(
                    side = eyeReq.side,
                    sph = eyeReq.sph.toDouble(),
                    cyl = eyeReq.cyl.toDouble(),
                    achse = eyeReq.achse,
                    pd = eyeReq.pd.toDouble(),
                    prism = eyeReq.prism?.toDouble(),
                    glassesConfig = glassesConfig
                )
                glassesConfig.eyeConfigs.add(eyeConfig)
            }

            customer.glassesConfigs.add(glassesConfig)
        }

        val saved = customerRepository.save(customer)
        log.info("Customer created with ID: {}", saved.id)

        return saved.toDto()
    }
}
