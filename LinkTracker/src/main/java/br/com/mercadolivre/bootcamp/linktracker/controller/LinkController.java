package br.com.mercadolivre.bootcamp.linktracker.controller;


import br.com.mercadolivre.bootcamp.linktracker.model.entity.Link;
import br.com.mercadolivre.bootcamp.linktracker.model.service.CreateLinkService;
import br.com.mercadolivre.bootcamp.linktracker.model.service.InvalidarService;
import br.com.mercadolivre.bootcamp.linktracker.model.service.MetricasService;
import br.com.mercadolivre.bootcamp.linktracker.model.service.RedirecionamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/link")
public class LinkController {

    private CreateLinkService createLinkService;
    private RedirecionamentoService redirecionamentoService;
    private MetricasService metricasService;
    private InvalidarService invalidarService;

    @Autowired
    public LinkController(CreateLinkService createLinkService,
                          RedirecionamentoService redirecionamentoService,
                          MetricasService metricasService,
                          InvalidarService invalidarService) {
        this.createLinkService = createLinkService;
        this.redirecionamentoService = redirecionamentoService;
        this.metricasService = metricasService;
        this.invalidarService = invalidarService;
    }

    @PostMapping
    public ResponseEntity<String> createLink(@RequestBody String link,
                                             @RequestHeader String senha){
        if (senha != ""){
            return new ResponseEntity<>(createLinkService.execute(new Link(link, senha)), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(createLinkService.execute(new Link(link)), HttpStatus.OK);
        }
    }

    @GetMapping("/{mascara}")
    public ResponseEntity<String> redirecionamento(@PathVariable String mascara,
                                                   @RequestHeader String senha){
        return new ResponseEntity<>(redirecionamentoService.execute(mascara, senha), HttpStatus.OK);
    }

    @GetMapping("/metrics/{mascara}")
    public ResponseEntity<String> metricas(@PathVariable String mascara){
        return new ResponseEntity<>(metricasService.execute(mascara), HttpStatus.OK);
    }

    @PostMapping("/invalidate/{mascara}")
    public ResponseEntity<String> invalidar(@PathVariable String mascara){
        return new ResponseEntity<>(invalidarService.execute(mascara), HttpStatus.OK);
    }

}
