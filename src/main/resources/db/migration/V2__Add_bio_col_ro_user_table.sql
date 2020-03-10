ALTER TABLE `user`
MODIFY COLUMN `bio`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' AFTER `gmt_modified`;
