-- MySQL Workbench Synchronization
-- Generated: 2022-04-26 15:59
-- Model: New Model
-- Version: 1.0
-- Project: ImobiliariaIF
-- Author: Danilo Souza Almeida

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE TABLE IF NOT EXISTS `imobiliaria_if`.`imovel` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(500) NOT NULL,
  `area` VARCHAR(45) NULL DEFAULT NULL,
  `quartos` INT NOT NULL,
  `salas` INT NOT NULL,
  `banheiros` INT NOT NULL,
  `suites` INT NOT NULL,
  `garagem` INT NOT NULL,
  `armarios` BIT(1) NOT NULL,
  `guardaroupas` BIT(1) NOT NULL,
  `valor` DECIMAL(9,2) NULL DEFAULT NULL,
  `dataCadastro` DATETIME NOT NULL,
  `dataDesativacao` DATETIME NULL DEFAULT NULL,
  `tipo_id` INT NOT NULL,
  `endereco_id` INT NOT NULL,
  `cliente_id` INT NOT NULL,
  `negociacao` VARCHAR(45) NOT NULL,
  `inquilino_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_imovel_cliente_idx` (`cliente_id` ASC) VISIBLE,
  INDEX `fk_imovel_tipo_idx` (`tipo_id` ASC) VISIBLE,
  INDEX `fk_imovel_inquilino_idx` (`inquilino_id` ASC) VISIBLE,
  INDEX `fk_imovel_endereco_idx` (`endereco_id` ASC) VISIBLE,
  CONSTRAINT `fk_imovel_cliente`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `imobiliaria_if`.`cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_imovel_tipo`
    FOREIGN KEY (`tipo_id`)
    REFERENCES `imobiliaria_if`.`tipo_imovel` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_imovel_inquilino`
    FOREIGN KEY (`inquilino_id`)
    REFERENCES `imobiliaria_if`.`cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_imovel_endereco`
    FOREIGN KEY (`endereco_id`)
    REFERENCES `imobiliaria_if`.`endereco` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `imobiliaria_if`.`cliente` (
  `id` INT NOT NULL,
  `nome` VARCHAR(80) NOT NULL,
  `cpf_cnpj` VARCHAR(45) NOT NULL,
  `data_desativacao` DATETIME NULL DEFAULT NULL,
  `telefone` VARCHAR(45) NOT NULL,
  `endereco_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_cliente_endereco_idx` (`endereco_id` ASC) VISIBLE,
  CONSTRAINT `fk_cliente_endereco`
    FOREIGN KEY (`endereco_id`)
    REFERENCES `imobiliaria_if`.`endereco` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `imobiliaria_if`.`usuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(20) NOT NULL,
  `sobrenome` VARCHAR(60) NULL DEFAULT NULL,
  `email` VARCHAR(80) NOT NULL,
  `senha` BLOB NOT NULL,
  `salt` BIGINT NOT NULL,
  `data_cadastro` DATETIME NOT NULL,
  `data_desativacao` DATETIME NULL DEFAULT NULL,
  `data_expiracao_senha` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = MyISAM
DEFAULT CHARACTER SET = big5;

CREATE TABLE IF NOT EXISTS `imobiliaria_if`.`permissao` (
  `id` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(150) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `imobiliaria_if`.`usuario_permissao` (
  `user_id` INT NOT NULL,
  `permission_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `permission_id`),
  INDEX `fk_user_has_permission_permission_idx` (`permission_id` ASC) VISIBLE,
  CONSTRAINT `fk_user_has_permission_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `imobiliaria_if`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_permission_permission`
    FOREIGN KEY (`permission_id`)
    REFERENCES `imobiliaria_if`.`permissao` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `imobiliaria_if`.`tipo_imovel` (
  `id` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `comercial` BIT(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `imobiliaria_if`.`imagem` (
  `id` INT NOT NULL,
  `url` VARCHAR(60) NOT NULL,
  `content_type` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `imobiliaria_if`.`imovel_imagem` (
  `imovel_id` INT NOT NULL,
  `imagem_id` INT NOT NULL,
  PRIMARY KEY (`imovel_id`, `imagem_id`),
  INDEX `fk_imovel_imagem_imagem_idx` (`imagem_id` ASC) VISIBLE,
  CONSTRAINT `fk_imovel_imagem_imovel`
    FOREIGN KEY (`imovel_id`)
    REFERENCES `imobiliaria_if`.`imovel` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_imovel_imagem_imagem`
    FOREIGN KEY (`imagem_id`)
    REFERENCES `imobiliaria_if`.`imagem` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `imobiliaria_if`.`banner` (
  `id` INT NOT NULL,
  `descricao` VARCHAR(150) NULL DEFAULT NULL,
  `link` VARCHAR(200) NULL DEFAULT NULL,
  `imagem_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_banner_imagem_idx` (`imagem_id` ASC) VISIBLE,
  CONSTRAINT `fk_banner_imagem`
    FOREIGN KEY (`imagem_id`)
    REFERENCES `imobiliaria_if`.`imagem` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `imobiliaria_if`.`movimento_caixa` (
  `id` INT NOT NULL,
  `descricao` VARCHAR(80) NOT NULL,
  `tipo_movimento` VARCHAR(45) NOT NULL,
  `data_movimento` DATETIME NOT NULL,
  `valor` DECIMAL(9,2) NOT NULL,
  `tipo_moeda_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_movimento_caixa_tipo_moeda_idx` (`tipo_moeda_id` ASC) VISIBLE,
  CONSTRAINT `fk_movimento_caixa_tipo_moeda`
    FOREIGN KEY (`tipo_moeda_id`)
    REFERENCES `imobiliaria_if`.`tipo_moeda` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `imobiliaria_if`.`tipo_moeda` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `imobiliaria_if`.`endereco` (
  `id` INT NOT NULL,
  `logradouro` VARCHAR(120) NOT NULL,
  `numero` VARCHAR(45) NOT NULL,
  `complemeto` VARCHAR(45) NULL DEFAULT NULL,
  `bairro` VARCHAR(45) NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `cep` VARCHAR(45) NOT NULL,
  `latitude` DOUBLE NULL DEFAULT NULL,
  `longitude` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `imobiliaria_if`.`configuracoes` (
  `id` INT NOT NULL,
  `email_envio` VARCHAR(45) NULL DEFAULT NULL,
  `senha_envio` VARCHAR(45) NULL DEFAULT NULL,
  `emails_recebimento` VARCHAR(45) NULL DEFAULT NULL,
  `nome_imobiliaria` VARCHAR(100) NOT NULL,
  `endereco_id` INT NULL DEFAULT NULL,
  `fone1` VARCHAR(45) NULL DEFAULT NULL,
  `fone2` VARCHAR(45) NULL DEFAULT NULL,
  `fone_whatsapp` VARCHAR(45) NULL DEFAULT NULL,
  `logo_id` INT NOT NULL,
  `tema_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_configuracoes_endereco_idx` (`endereco_id` ASC) VISIBLE,
  INDEX `fk_configuracoes_imagem_idx` (`logo_id` ASC) VISIBLE,
  INDEX `fk_configuracoes_tema_idx` (`tema_id` ASC) VISIBLE,
  CONSTRAINT `fk_configuracoes_endereco`
    FOREIGN KEY (`endereco_id`)
    REFERENCES `imobiliaria_if`.`endereco` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_configuracoes_imagem`
    FOREIGN KEY (`logo_id`)
    REFERENCES `imobiliaria_if`.`imagem` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_configuracoes_tema`
    FOREIGN KEY (`tema_id`)
    REFERENCES `imobiliaria_if`.`tema` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `imobiliaria_if`.`tema` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `acent_color` VARCHAR(45) NOT NULL,
  `header_background` VARCHAR(45) NOT NULL,
  `header_background_hover` VARCHAR(45) NOT NULL,
  `header_text_color` VARCHAR(45) NOT NULL,
  `footer_background` VARCHAR(45) NOT NULL,
  `footer_border_color` VARCHAR(45) NOT NULL,
  `footer_text_color` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `imobiliaria_if`.`sobre` (
  `id` INT NOT NULL,
  `titulo` VARCHAR(100) NOT NULL,
  `texto` LONGTEXT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `imobiliaria_if`.`orientacoes` (
  `id` INT NOT NULL,
  `titulo` VARCHAR(100) NOT NULL,
  `texto` LONGTEXT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
