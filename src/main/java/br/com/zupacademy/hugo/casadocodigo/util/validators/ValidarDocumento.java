package br.com.zupacademy.hugo.casadocodigo.util.validators;

import br.com.zupacademy.hugo.casadocodigo.cliente.NovoClienteRequestDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ValidarDocumento implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return NovoClienteRequestDTO.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) return;

        NovoClienteRequestDTO request = (NovoClienteRequestDTO) target;

        if(!request.documentoValido()) errors.rejectValue("documento", null, "Documento precisa ser um cpf ou cnpj");

    }
}
