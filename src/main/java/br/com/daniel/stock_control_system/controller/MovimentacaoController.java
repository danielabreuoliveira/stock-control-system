package br.com.daniel.stock_control_system.controller;

import br.com.daniel.stock_control_system.dto.request.MovimentacaoRequest;
import br.com.daniel.stock_control_system.dto.response.MovimentacaoResponse;
import br.com.daniel.stock_control_system.service.MovimentacaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movimentacoes")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class MovimentacaoController {

    private final MovimentacaoService movimentacaoService;

    @PostMapping
    public MovimentacaoResponse salvar(@RequestBody @Valid MovimentacaoRequest request){
        return movimentacaoService.salvar(request);
    }
}
