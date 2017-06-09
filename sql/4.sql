USE dom;

ALTER TABLE `player` ADD COLUMN `game_order` INTEGER(10) NOT NULL;

INSERT INTO `sql_files` (`sql_file_name`, `run_date`) VALUES ('4.sql', NOW());