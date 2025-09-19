package giovanni.backend.controller

import giovanni.backend.dto.CustomerRequest
import giovanni.backend.dto.CustomerResponse
import giovanni.backend.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/api/v1/customers")
@CrossOrigin(origins = ["http://localhost:4200"])
class CustomerController(
    private val customerService: CustomerService
) {

    @PostMapping
    fun addCustomer(@RequestBody customerRequest: CustomerRequest): CustomerResponse {
        return customerService.addCustomer(customerRequest)
    }

    @PutMapping("/{id}")
    fun updateCustomer(
        @PathVariable id: UUID,
        @RequestBody customerRequest: CustomerRequest
    ): CustomerResponse {
        return customerService.updateCustomer(id, customerRequest)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCustomer(@PathVariable id: UUID) {
        customerService.deleteCustomer(id)
    }

    @GetMapping("/{id}")
    fun getCustomerById(@PathVariable id: UUID): CustomerResponse {
        return customerService.getCustomerById(id)
    }

    @GetMapping
    fun searchCustomers(
        @RequestParam(required = false) vorname: String?,
        @RequestParam(required = false) familienname: String?,
    ): List<CustomerResponse> {
        return customerService.searchCustomers(vorname, familienname)
    }
}