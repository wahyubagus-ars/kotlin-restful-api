package rnd.restful_api.repository

import org.springframework.data.repository.CrudRepository
import rnd.restful_api.domain.dao.Product

interface ProductRepository: CrudRepository<Product, Long> {
}