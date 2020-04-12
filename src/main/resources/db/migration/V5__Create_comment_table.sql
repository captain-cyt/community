CREATE TABLE `NewTable` (
`id`  bigint NOT NULL AUTO_INCREMENT ,
`parent_id`  bigint NOT NULL COMMENT '父类id' ,
`type`  int NULL COMMENT '父类的类型' ,
`commentator`  int NOT NULL COMMENT '评论人的id' ,
`gmt_create`  bigint NOT NULL COMMENT '回复的创建时间' ,
`gmt_modified`  bigint NOT NULL COMMENT '回复的更新时间' ,
`like_count`  bigint NULL DEFAULT 0 ,
PRIMARY KEY (`id`)
)
;

