## Banco de dados

Abaixo se encontra o script para criação do banco de dados

```
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';


-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------


-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ecommerce` DEFAULT CHARACTER SET utf8 ;
USE `ecommerce` ;


-- -----------------------------------------------------
-- Table `mydb`.`Pedidos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecommerce`.`pedido` (
`numero_pedido` INT NOT NULL,
`codigo_cliente` VARCHAR(45) NOT NULL,
PRIMARY KEY (`numero_pedido`))
ENGINE = InnoDB;



-- -----------------------------------------------------
-- Table `mydb`.`Clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecommerce`.`cliente` (
`codigo_cliente` INT NOT NULL AUTO_INCREMENT,
`nome` VARCHAR(45) NOT NULL,
`cpf` VARCHAR(45) NOT NULL,
`sexo` VARCHAR(45) NOT NULL,
`telefone` VARCHAR(45) NOT NULL,
`situacao` VARCHAR(45) NOT NULL default "Ativo",
PRIMARY KEY (`codigo_cliente`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mydb`.`Produtos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecommerce`.`produto` (
`codigo_produto` INT NOT NULL auto_increment,
`nome` VARCHAR(45) NOT NULL,
`descricao` VARCHAR(45) NOT NULL,
`preco` VARCHAR(45) NOT NULL,
`quantidade` INT NOT NULL,
PRIMARY KEY (`codigo_produto`))
ENGINE = InnoDB;

select * from produto;


-- -----------------------------------------------------
-- Table `mydb`.`Pedidos_has_Produtos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecommerce`.`compra` (
`quantidade` VARCHAR(45) NOT NULL,
`preco` VARCHAR(45) NOT NULL,
`data` VARCHAR(45) NOT NULL,
`numero_pedido` VARCHAR(45) NOT NULL,
`codigo_produto` VARCHAR(45) NOT NULL)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
/*SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;*/
```
