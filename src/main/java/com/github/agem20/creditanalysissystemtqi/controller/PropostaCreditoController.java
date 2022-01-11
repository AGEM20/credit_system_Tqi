package com.github.agem20.creditanalysissystemtqi.controller;

import com.github.agem20.creditanalysissystemtqi.comum.Utils;
import com.github.agem20.creditanalysissystemtqi.dto.Erros;
import com.github.agem20.creditanalysissystemtqi.dto.PropostaCreditoDTO;
import com.github.agem20.creditanalysissystemtqi.entity.PropostaCredito;
import com.github.agem20.creditanalysissystemtqi.operation.PropostaCreditoOperacao;
import com.github.agem20.creditanalysissystemtqi.validation.PropostaCreditoValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class PropostaCreditoController {

    @Autowired
    PropostaCreditoOperacao propostaOperacao;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        if (binder.getTarget() instanceof PropostaCredito) {
            binder.setValidator((Validator) new PropostaCreditoValidation());
        }
    }

    @RequestMapping(value= "/propostas", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> salvar(@Valid @RequestBody PropostaCredito proposta, BindingResult result) {

        if (result.hasErrors()) {
            Erros erroNegocial = new Erros(HttpStatus.BAD_REQUEST, result.getAllErrors());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroNegocial);
        }

        proposta.getCliente().setCpf(Utils.somenteNumeros(proposta.getCliente().getCpf()));

        PropostaCreditoDTO propostaResultado = propostaOperacao.analisarProposta(proposta);
        return ResponseEntity.ok(propostaResultado);
    }

    @RequestMapping(value="/propostas", params = { "cpf" },  method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> consultarUltimaPropostaSubmetida(@RequestParam(value = "cpf") String cpf) {
        cpf = Utils.somenteNumeros(cpf);
        List<PropostaCreditoDTO> propostasResultado = propostaOperacao.consultarPropostasSubmetidas(cpf);

        if(propostasResultado.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.ok(propostasResultado);
    }

    @RequestMapping(value= "/", method = RequestMethod.GET)
    public ModelAndView redirect() {
        return new ModelAndView("redirect:/actuator/health");
    }


}
