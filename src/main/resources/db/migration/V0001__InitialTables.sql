-- -----------------------------------------------------
-- Table `db`.`tbl_address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db`.`tbl_address` (
  `id` VARCHAR(36) NOT NULL,
  `city` VARCHAR(255) NULL DEFAULT NULL,
  `country` VARCHAR(255) NULL DEFAULT NULL,
  `district` VARCHAR(255) NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `db`.`tbl_category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db`.`tbl_category` (
  `id` VARCHAR(36) NOT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `db`.`tbl_client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db`.`tbl_client` (
  `id` VARCHAR(36) NOT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `address_id` VARCHAR(36) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKj5rwjul0p85ssv5b70onud6lf` (`address_id` ASC) VISIBLE,
  CONSTRAINT `FKj5rwjul0p85ssv5b70onud6lf`
    FOREIGN KEY (`address_id`)
    REFERENCES `db`.`tbl_address` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `db`.`tbl_order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db`.`tbl_order` (
  `id` VARCHAR(36) NOT NULL,
  `client_id` VARCHAR(36) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKsbyst7l34odsvemrm3x60o5f3` (`client_id` ASC) VISIBLE,
  CONSTRAINT `FKsbyst7l34odsvemrm3x60o5f3`
    FOREIGN KEY (`client_id`)
    REFERENCES `db`.`tbl_client` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `db`.`tbl_product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db`.`tbl_product` (
  `id` VARCHAR(36) NOT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `value` DECIMAL(19,2) NULL DEFAULT NULL,
  `category_id` VARCHAR(36) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKfq7110lh85cseoy13cgni7pet` (`category_id` ASC) VISIBLE,
  CONSTRAINT `FKfq7110lh85cseoy13cgni7pet`
    FOREIGN KEY (`category_id`)
    REFERENCES `db`.`tbl_category` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `db`.`tbl_sale`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db`.`tbl_sale` (
  `id` VARCHAR(36) NOT NULL,
  `amount` INT(11) NULL DEFAULT NULL,
  `order_id` VARCHAR(36) NOT NULL,
  `product_id` VARCHAR(36) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKmpn5d2ubcn9nu7f1kl0quvawe` (`order_id` ASC) VISIBLE,
  INDEX `FK4858knvvds589kt744tsobast` (`product_id` ASC) VISIBLE,
  CONSTRAINT `FK4858knvvds589kt744tsobast`
    FOREIGN KEY (`product_id`)
    REFERENCES `db`.`tbl_product` (`id`),
  CONSTRAINT `FKmpn5d2ubcn9nu7f1kl0quvawe`
    FOREIGN KEY (`order_id`)
    REFERENCES `db`.`tbl_order` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;
