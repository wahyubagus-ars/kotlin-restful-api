package rnd.restful_api.repository

import org.springframework.data.jpa.repository.JpaRepository
import rnd.restful_api.domain.dao.Product

interface ProductRepository: JpaRepository<Product, Long> {

}