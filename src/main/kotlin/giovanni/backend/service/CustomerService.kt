package giovanni.backend.service

import giovanni.backend.dto.CustomerRequest
import giovanni.backend.dto.CustomerResponse
import giovanni.backend.mapper.toDto
import giovanni.backend.mapper.toEntity
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import giovanni.backend.repository.CustomerRepository
import java.util.UUID


@Service
class CustomerService(
    private val customerRepository: CustomerRepository
) {
    private val log = LoggerFactory.getLogger(CustomerService::class.java)

    @Transactional
    fun addCustomer(request: CustomerRequest): CustomerResponse {
        log.info("Adding new customer: {} {}", request.vorname, request.familienname)
        val customer = request.toEntity()
        val saved = customerRepository.save(customer)
        log.info("Customer created with ID: {}", saved.id)
        return saved.toDto()
    }

    fun searchCustomers(vorname: String?, nachname: String?): List<CustomerResponse> {
        log.info("Searching customers with filter: $vorname, $nachname")
        return customerRepository.findAll()
            .filter {
                (vorname == null || it.vorname?.contains(vorname, ignoreCase = true) == true) &&
                        (nachname == null || it.familienname?.contains(nachname, ignoreCase = true) == true)
            }
            .map { it.toDto() }
    }

    fun getCustomerById(id: UUID): CustomerResponse =
        customerRepository.findById(id)
            .orElseThrow { NoSuchElementException("Customer with id $id not found") }
            .toDto()

    @Transactional
    fun updateCustomer(id: UUID, request: CustomerRequest): CustomerResponse {
        val newCustomer = request.toEntity().copy(id = id)
        return customerRepository.save(newCustomer).toDto()
    }

    @Transactional
    fun deleteCustomer(id: UUID) {
        if (!customerRepository.existsById(id)) {
            throw NoSuchElementException("Customer with id $id not found")
        }
        customerRepository.deleteById(id)
    }
}

