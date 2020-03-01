# supero
Teste supero SC
<br>
#Projeto feito com PrimeFaces, Mysql, Spring Security, JavaEE 7
<br>
#URL da aplicação rodando localmente 
http://localhost:8080/SuperoTasklist/Login.xhtml

#Dados de acesso ao banco de dados Mysql
Schema - supero
Usuario - root
Senha - root

#SQL de criação da tabela tasklist
#CREATE TABLE `tasklist` (
  `idtasklist` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(60) DEFAULT NULL,
  `descricao` varchar(80) DEFAULT NULL,
  `status` varchar(5) DEFAULT NULL,
  `dataalteracao` datetime DEFAULT NULL,
  `datacadastro` datetime DEFAULT NULL,
  `dataexclusao` datetime DEFAULT NULL,
  PRIMARY KEY (`idtasklist`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

#SQL de criação da tabela usuario
#select * from usuarioCREATE TABLE `usuario` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `login` varchar(255) NOT NULL,
  `nome` varchar(60) NOT NULL,
  `senha` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

#SQL de criação da tabela grupo
#CREATE TABLE `grupo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(60) DEFAULT NULL,
  `descricao` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

#SQL de criação da tabela usuario_grupo
#CREATE TABLE `usuario_grupo` (
  `usuario_id` int NOT NULL,
  `grupo_id` int NOT NULL,
  PRIMARY KEY (`usuario_id`,`grupo_id`),
  KEY `FK_5p20y5panoea7wc040qm6eemd` (`grupo_id`),
  CONSTRAINT `FK_5p20y5panoea7wc040qm6eemd` FOREIGN KEY (`grupo_id`) REFERENCES `grupo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

#Insert de usuários
#INSERT INTO usuario(id, email, login, nome, senha)VALUES (1, 'supero@supero.com', 'supero', 'supero', '123');

#Insert de grupos
#insert into grupo (nome,descricao) values('ADMINISTRADORES','ADMINISTRADORES');

#Insert de usuario_grupo
#insert into usuario_grupo (usuario_id,grupo_id)values(1,1);
#--Atenção nesse insert confirmar os ID criados nos insert anteriores.--

#Para baixar o projeto via Github clonando
https://github.com/mmss07/supero.git
