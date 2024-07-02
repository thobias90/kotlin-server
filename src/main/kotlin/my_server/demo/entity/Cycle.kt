package my_server.demo.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
class Cycle(
    @Id
    @GeneratedValue
    var id: Int = 0,
    var name: String = "",
    var delay: Int = 0,
    var temperature: String = "",
    var spinSpeed: String = "",
    var soilLevel: String = ""
)