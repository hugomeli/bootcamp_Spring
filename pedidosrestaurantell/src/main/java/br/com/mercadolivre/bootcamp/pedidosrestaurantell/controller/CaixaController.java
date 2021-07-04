package br.com.mercadolivre.bootcamp.pedidosrestaurantell.controller;


import br.com.mercadolivre.bootcamp.pedidosrestaurantell.model.entities.Caixa;
import br.com.mercadolivre.bootcamp.pedidosrestaurantell.model.repository.CaixaRepository;
import br.com.mercadolivre.bootcamp.pedidosrestaurantell.model.repository.MesaRepository;
import br.com.mercadolivre.bootcamp.pedidosrestaurantell.service.caixaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/caixa")
public class CaixaController {

    MesaRepository mesaRepository;
    CaixaRepository caixaRepository;

    public CaixaController(MesaRepository mesaRepository, CaixaRepository caixaRepository) {
        this.mesaRepository = mesaRepository;
        this.caixaRepository = caixaRepository;
    }

    @GetMapping("/fechar/mesa{id}")
    public String fechamentoDeMesa(@PathVariable Long id){
        Double quantiaNaMesa = caixaService.fecharMesa(mesaRepository.findById(id));
        caixaRepository.retornaCaixa().adicionaValor(quantiaNaMesa);
        return "Mesa " + id + " foi fechada." +
                " Foi adicionada a quantia de R$" + quantiaNaMesa +
                " ao caixa";
    }

    @GetMapping("/consultar")
    public String consultaCaixa(){
        return "Valor atual no caixa: R$" + caixaService.consultaValorCaixa(caixaRepository.retornaCaixa());
    }

}
