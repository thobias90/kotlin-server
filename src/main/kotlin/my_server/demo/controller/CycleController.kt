package my_server.demo.controller

import my_server.demo.entity.Cycle
import my_server.demo.repository.CycleRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/cycles")
class CycleController(private val cycleRepository: CycleRepository) {
  @GetMapping
  fun list(@RequestParam(required = false) name: String?): List<Cycle> {
    return if (name.isNullOrEmpty()) {
      cycleRepository.findAll()
    } else {
      cycleRepository.findByNameContainingIgnoreCase(name)
    }
  }

  @GetMapping("/{id}")
  fun getById(@PathVariable id: Int): ResponseEntity<Cycle> {
    val cycle = cycleRepository.findById(id)
    return if (cycle.isPresent) {
      ResponseEntity.ok(cycle.get())
    } else {
      ResponseEntity.notFound().build()
    }
  }

  @PostMapping("")
  fun save(@RequestBody cycleDetails: Cycle): ResponseEntity<Cycle> {
    val cycle = cycleRepository.save(cycleDetails)
    return ResponseEntity.ok(cycle)
  }

  @DeleteMapping("/{id}")
  fun delete(@PathVariable id: Int): ResponseEntity<Unit> {
    cycleRepository.deleteById(id)
    return ResponseEntity.noContent().build()
  }
}
