-- 仿真模型型号
drop table if exists `category`;
create table `category` (
  `id` char(8) not null comment 'id',
  `name` varchar(50) comment '名称',
  `dalei` varchar(8) comment '大类',
  `leibie` varchar(8) comment '类别',
  primary key (`id`)
) engine=innodb default charset=utf8mb4 comment='型号';

insert into `category` (id, name, dalei, leibie) values ('00000000', '歼-16战机', '飞行器', '战斗机');
insert into `category` (id, name, dalei, leibie) values ('00000001', 'FC-1"枭龙"/JF-17"雷电"多用途攻击机', '飞行器', '战斗机');