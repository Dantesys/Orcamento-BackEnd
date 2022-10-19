package com.dantesys.orcamento.controllers

import com.dantesys.orcamento.dtos.AddDTO
import com.dantesys.orcamento.dtos.Mensagem
import com.dantesys.orcamento.entities.Modelo
import com.dantesys.orcamento.services.ModeloService
import com.dantesys.orcamento.services.UserService
import io.jsonwebtoken.Jwts
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/modelo")
class ModeloController(private val modeloService: ModeloService,private val userService: UserService){
    @GetMapping("/all")
    @ResponseBody
    fun getAllModels(): Iterable<Modelo?>? {
        return modeloService.findAll()
    }
    @GetMapping("/{id}")
    @ResponseBody
    fun getIdModels(@PathVariable id:Int): Modelo? {
        return modeloService.findByIdOrNull(id)
    }
    @PostMapping("/add")
    fun addModel(@RequestBody data:AddDTO,@CookieValue("jwt") jwt:String?):ResponseEntity<Any>{
        try {
            if(jwt==null){
                return ResponseEntity.status(401).body(Mensagem("Não Autorizado"))
            }
            val body = Jwts.parserBuilder().build().parseClaimsJws(jwt).body
            val user = userService.getById(body.issuer.toInt())
            val modelo = Modelo(data.nome,data.espessura,data.preco,user.get())
            return ResponseEntity.ok(modeloService.save(modelo))
        } catch (e:Exception) {
            return ResponseEntity.status(401).body(Mensagem("Não Autorizado"))
        }
    }
    @PutMapping("/edit/{id}")
    fun editModel(@PathVariable id:Int,@RequestBody data:AddDTO,@CookieValue("jwt") jwt:String?):ResponseEntity<Any>{
        try {
            if(jwt==null){
                return ResponseEntity.status(401).body(Mensagem("Não Autorizado"))
            }
            val body = Jwts.parserBuilder().build().parseClaimsJws(jwt).body
            val user = userService.getById(body.issuer.toInt())
            val modelo = modeloService.findByIdOrNull(id)
            if (modelo != null) {
                modelo.nome = data.nome
                modelo.espessura = data.espessura
                modelo.preco = data.preco
                if(modelo.user==user.get()){
                    return ResponseEntity.ok(modeloService.save(modelo))
                }
                return ResponseEntity.status(401).body(Mensagem("Não Autorizado"))
            }
            return ResponseEntity.status(404).body(Mensagem("Modelo não encontrado"))
        } catch (e:Exception) {
            return ResponseEntity.status(401).body(Mensagem("Não Autorizado"))
        }
    }
    @DeleteMapping("/del/{id}")
    fun delModel(@PathVariable id:Int,@CookieValue("jwt") jwt:String?):ResponseEntity<Any>{
        try {
            if(jwt==null){
                return ResponseEntity.status(401).body(Mensagem("Não Autorizado"))
            }
            val body = Jwts.parserBuilder().build().parseClaimsJws(jwt).body
            val user = userService.getById(body.issuer.toInt())
            val modelo = modeloService.findByIdOrNull(id)
            if (modelo != null) {
                if(modelo.user==user.get()){
                    modeloService.delete(modelo)
                    return ResponseEntity.ok(Mensagem("Sucesso"))
                }
                return ResponseEntity.status(401).body(Mensagem("Não Autorizado"))
            }
            return ResponseEntity.status(404).body(Mensagem("Modelo não encontrado"))
        } catch (e:Exception) {
            return ResponseEntity.status(401).body(Mensagem("Não Autorizado"))
        }
    }
}