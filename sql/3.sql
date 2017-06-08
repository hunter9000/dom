USE dom;

CREATE TABLE `game` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (`id`)
) COLLATE='utf8_general_ci' ENGINE=InnoDB;

CREATE TABLE `player` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`user` BIGINT(20) NOT NULL,
	`game` BIGINT(20) NOT NULL,
	PRIMARY KEY (`id`),
    INDEX `player__user` (`user`),
    INDEX `player__game` (`game`),
    CONSTRAINT `player__user` FOREIGN KEY (`user`) REFERENCES `user` (`id`),
    CONSTRAINT `player__game` FOREIGN KEY (`game`) REFERENCES `game` (`id`)
) COLLATE='utf8_general_ci' ENGINE=InnoDB;

CREATE TABLE `card` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`card_type` VARCHAR(255) NOT NULL,
	PRIMARY KEY (`id`)
) COLLATE='utf8_general_ci' ENGINE=InnoDB;

CREATE TABLE `player_deck` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`player_id` BIGINT(20) NOT NULL,
	`card_id` BIGINT(20) NOT NULL,
	PRIMARY KEY (`id`),
    INDEX `player_deck__player_id` (`player_id`),
    INDEX `player_deck__card_id` (`card_id`),
    CONSTRAINT `player_deck__player_id` FOREIGN KEY (`player_id`) REFERENCES `player` (`id`),
    CONSTRAINT `player_deck__card_id` FOREIGN KEY (`card_id`) REFERENCES `card` (`id`)
) COLLATE='utf8_general_ci' ENGINE=InnoDB;

CREATE TABLE `player_hand` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`player_id` BIGINT(20) NOT NULL,
	`card_id` BIGINT(20) NOT NULL,
	PRIMARY KEY (`id`),
    INDEX `player_hand__player_id` (`player_id`),
    INDEX `player_hand__card_id` (`card_id`),
    CONSTRAINT `player_hand__player_id` FOREIGN KEY (`player_id`) REFERENCES `player` (`id`),
    CONSTRAINT `player_hand__card_id` FOREIGN KEY (`card_id`) REFERENCES `card` (`id`)
) COLLATE='utf8_general_ci' ENGINE=InnoDB;

CREATE TABLE `player_discard` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`player_id` BIGINT(20) NOT NULL,
	`card_id` BIGINT(20) NOT NULL,
	PRIMARY KEY (`id`),
    INDEX `player_discard__player_id` (`player_id`),
    INDEX `player_discard__card_id` (`card_id`),
    CONSTRAINT `player_discard__player_id` FOREIGN KEY (`player_id`) REFERENCES `player` (`id`),
    CONSTRAINT `player_discard__card_id` FOREIGN KEY (`card_id`) REFERENCES `card` (`id`)
) COLLATE='utf8_general_ci' ENGINE=InnoDB;



INSERT INTO `sql_files` (`sql_file_name`, `run_date`) VALUES ('3.sql', NOW());