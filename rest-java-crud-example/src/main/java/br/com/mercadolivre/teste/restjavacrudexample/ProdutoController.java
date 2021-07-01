package br.com.mercadolivre.teste.restjavacrudexample;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
public class ProdutoController {

    ProdutoRepository repository;

    // Mostrar todos os produtos
    @GetMapping("/produto")
    public List<Produto> getAllProdutos(){
        return repository.findAll();
    }

    // Pegar um produto por ID
    @GetMapping("/produto/{id}")
    public Produto getProdutoPorId(@PathVariable Long id){
        return repository.findById(id).get();
    }

    // Salvar um produto
    @PostMapping("/produto")
    public Produto saveProduto(@RequestBody Produto produto){
        return repository.save(produto);
    }

    // Deletar um produto
    @DeleteMapping("/produto/{id}")
    public void deleteProduto(@PathVariable Long id){
        repository.deleteById(id);
    }

    // Update de um produto
    @PostMapping("/produto/{id}")
    public ResponseEntity updateProduto(@PathVariable long id, @RequestBody Produto produtoNovo){
        return repository.findById(id).map(record -> {
            record.setMarca(produtoNovo.getMarca());
            record.setDescricao(produtoNovo.getDescricao());
            record.setValor(produtoNovo.getValor());
            Produto atualizado = repository.save(record);
            return ResponseEntity.ok().body(atualizado);
        }).orElse(ResponseEntity.notFound().build());
    }


}
