-- Comandos sempre na mesma linha

INSERT INTO `permissao` (nome, data_criacao) VALUES (`administrador`, CURRENT_TIMESTAMP());

INSERT INTO `pessoa` (nome, cpf, email, senha, endereco, cep, data_criacao) VALUES (`administrador`, `99999999999`, `wesleyguilhermecastilho@gmail.com`, `123456789`, `Rua Joao G. 200`, `12345678`, CURRENT_TIMESTAMP());

INSERT INTO `permissaoPessoa` (fk_pessoa, fk_permissao, data_criacao) VALUES (1, 1, CURRENT_TIMESTAMP())