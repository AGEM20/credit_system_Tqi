package com.github.agem20.creditanalysissystemtqi.validation;

import java.util.Calendar;
import java.util.InputMismatchException;

import com.github.agem20.creditanalysissystemtqi.comum.Utils;
import com.github.agem20.creditanalysissystemtqi.entity.PropostaCredito;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class PropostaCreditoValidation implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return PropostaCredito.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object objeto, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cliente.nome", "field.required", "O nome do cliente é obrigatório.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cliente.dataNascimento", "field.required", "A data de nascimento do cliente é obrigatório.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cliente.sexo", "field.required", "O sexo do cliente é obrigatório.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cliente.estadoCivil", "field.required", "O estado civil do cliente é obrigatório.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cliente.estado", "field.required", "O estado do cliente é obrigatório.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cliente.dependentes", "field.required", "O número de dependentes do cliente é obrigatório.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cliente.renda", "field.required", "A renda do cliente é obrigatório.");

        PropostaCredito proposta = (PropostaCredito) objeto;

        if (proposta.getCliente().getCpf() == null || proposta.getCliente().getCpf().isEmpty()) {
            errors.rejectValue("cliente.cpf", "field.required", "CPF do cliente é obrigatório.");
        } else if (!isCPF(Utils.somenteNumeros(proposta.getCliente().getCpf()))) {
            errors.rejectValue("cliente.cpf", "cpf.invalido", "O CPF informado é inválido.");
        }

        Calendar dataNascimento = Calendar.getInstance();
        dataNascimento.setTime(proposta.getCliente().getDataNascimento());

        Calendar dataMaximaNascimento = Calendar.getInstance();
        dataMaximaNascimento.add(Calendar.YEAR, -130);

        if (dataNascimento.after(Calendar.getInstance().getTime())
                || dataNascimento.before(dataMaximaNascimento)) {
            errors.rejectValue("cliente.dataNascimento", "dataNascimento.invalido", "A data de nascimento informada é inválida.");
        }

    }

    public static boolean isCPF(String cpf) {
        // considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222") || cpf.equals("33333333333") || cpf.equals("44444444444")
                || cpf.equals("55555555555") || cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888") || cpf.equals("99999999999")
                || (cpf.length() != 11))
            return (false);

        char dig10, dig11;
        int sm, i, r, num, peso;

        // "try" - protege o codigo para eventuais erros de conversao de tipo
        // (int)
        try {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                // converte o i-esimo caractere do CPF em um numero:
                // por exemplo, transforma o caractere '0' no inteiro 0
                // (48 eh a posicao de '0' na tabela ASCII)
                num = (int) (cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else
                dig10 = (char) (r + 48); // converte no respectivo caractere
            // numerico

            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else
                dig11 = (char) (r + 48);

            // Verifica se os digitos calculados conferem com os digitos
            // informados.
            if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10)))
                return (true);
            else
                return false;
        } catch (InputMismatchException erro) {
            return (false);
        }
    }

}