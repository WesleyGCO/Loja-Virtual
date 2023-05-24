package com.castilho.backend.controle;

import java.io.Reader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.castilho.backend.entidade.Estado;
import com.castilho.backend.servico.EstadoServico;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

@RestController
@RequestMapping("/estado")
@CrossOrigin
public class EstadoControle {
    
    @Autowired
    private EstadoServico estadoServico;

    // localhost:8080/estado/ - com verbo get
    @GetMapping 
    public List<Estado> listarTodos(){
        return estadoServico.listarTodos();
    }

    // localhost:8080/estado/ - com verbo post
    @PostMapping
    public Estado salvar(@RequestBody Estado estado){
        return estadoServico.salvar(estado);
    }

    // localhost:8080/estado/1 - com verbo delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirEstado(@PathVariable Long id) {
        try {
            estadoServico.excluir(id);
            return ResponseEntity.ok("Estado excluído com sucesso");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/importar")
    public String importaCSV(@RequestParam("file") MultipartFile file) throws IOException, CsvException {
        //if (!file.getOriginalFilename().endsWith(".csv")) {
        //    return "Por favor, informe um arquivo .csv válido!";
        //}

        try (Reader reader = Files.newBufferedReader(Paths.get(file.getOriginalFilename()));
                CSVReader csvReader = new CSVReader(reader)) {
            List<String[]> records = csvReader.readAll();
            for (String[] record : records) {
                String id = record[0];
                String nome = record[1];
                String sigla = record[2];

                // Aqui você pode salvar os dados no banco de dados ou realizar qualquer outra
                // ação necessária
                Estado estado = new Estado();
                estado.setId(Long.parseLong(id));
                estado.setNome(nome);
                estado.setSigla(sigla);

                estadoServico.salvar(estado);
            }
        }
        return "Arquivo CSV importado com sucesso!";
    }
}
