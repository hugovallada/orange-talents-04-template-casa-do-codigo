package br.com.zupacademy.hugo.casadocodigo.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    @Transactional
    public void criarAutor(@RequestBody @Valid AutorRequestDTO autorDto){
        autorRepository.save(autorDto.toModel());
    }
}
