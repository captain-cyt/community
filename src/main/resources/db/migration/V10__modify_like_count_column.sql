ALTER TABLE `question`
    MODIFY COLUMN `like_count`  int(255) NULL DEFAULT NULL AFTER `creator`;

