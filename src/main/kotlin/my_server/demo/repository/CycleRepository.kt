package my_server.demo.repository

import my_server.demo.entity.Cycle
import org.springframework.data.jpa.repository.JpaRepository

interface CycleRepository : JpaRepository<Cycle, Int> {
  fun findByNameContainingIgnoreCase(name: String): List<Cycle>
}