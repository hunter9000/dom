USE dom;

CREATE TABLE `card_stack` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`game` BIGINT(20) NOT NULL,
	`card_type` VARCHAR(255) NOT NULL,
    `quantity` INTEGER NOT NULL,
	PRIMARY KEY (`id`),
    INDEX `card_stack__game` (`game`),
    CONSTRAINT `card_stack__game` FOREIGN KEY (`game`) REFERENCES `game` (`id`)
) COLLATE='utf8_general_ci' ENGINE=InnoDB;

ALTER TABLE `game` ADD COLUMN `curr_player` BIGINT(20) NOT NULL;

INSERT INTO `sql_files` (`sql_file_name`, `run_date`) VALUES ('5.sql', NOW());