package br.com.zupacademy.hugo.casadocodigo.cliente;

import br.com.zupacademy.hugo.casadocodigo.util.validators.EstadoNaoNuloSeExistir;
import br.com.zupacademy.hugo.casadocodigo.util.validators.ValidarDocumento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private EstadoNaoNuloSeExistir estadoNaoNuloSeExistir;

    @Autowired
    private ValidarDocumento validarDocumento;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(estadoNaoNuloSeExistir, validarDocumento);
    }

    @PostMapping
    @Transactional
    public ClienteIdResponseDTO cadastrarCliente(@RequestBody @Valid NovoClienteRequestDTO clienteRequestDTO){
        Cliente cliente = clienteRequestDTO.toCliente(entityManager);
        entityManager.persist(cliente);

        return new ClienteIdResponseDTO(cliente);
    }
}
