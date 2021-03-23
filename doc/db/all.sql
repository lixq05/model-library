-- 机动组件模型库
-- 仿真模型型号
drop table if exists `category`;
create table `category` (
  `id` char(8) not null comment 'id',
  `name` varchar(50) comment '名称',
  `dalei` varchar(8) comment '大类',
  `leibie` varchar(8) comment '类别',
  `model_id` char(8) comment '模型库id',
  primary key (`id`)
) engine=innodb default charset=utf8mb4 comment='型号';

insert into `category` (id, name, dalei, leibie, model_id) values ('00000000', '歼-16战机', '飞行器', '战斗机', '11111111');
insert into `category` (id, name, dalei, leibie, model_id) values ('00000001', 'FC-1"枭龙"/JF-17"雷电"多用途攻击机', '飞行器', '战斗机','11111111');
insert into `category` (id, name, dalei, leibie, model_id) values ('00000002', '苏-27战斗机', '飞行器', '战斗机','11111111');
insert into `category` (id, name, dalei, leibie, model_id) values ('00000003', 'LCA战斗机', '飞行器', '战斗机','11111111');
insert into `category` (id, name, dalei, leibie, model_id) values ('00000004', '苏-30/苏-33“侧卫” 制空战斗机和对地攻击机', '飞行器', '战斗机','11111111');
insert into `category` (id, name, dalei, leibie, model_id) values ('00000005', 'F-16“战隼', '飞行器', '战斗机','11111111');
insert into `category` (id, name, dalei, leibie, model_id) values ('00000006', '麦克唐纳F-15E“打击鹰” 双座双发打击战斗机', '飞行器', '战斗机','11111111');
insert into `category` (id, name, dalei, leibie, model_id) values ('00000007', '歼-31战斗机', '飞行器', '战斗机','11111111');
insert into `category` (id, name, dalei, leibie, model_id) values ('00000008', 'F-15鹰式战斗机', '飞行器', '战斗机','11111111');
insert into `category` (id, name, dalei, leibie, model_id) values ('00000009', '歼-20战斗机', '飞行器', '战斗机','11111111');
insert into `category` (id, name, dalei, leibie, model_id) values ('00000010', 'F-35“闪电II', '飞行器', '战斗机','11111111');
insert into `category` (id, name, dalei, leibie, model_id) values ('00000011', '歼-11战斗机', '飞行器', '战斗机','11111111');
insert into `category` (id, name, dalei, leibie, model_id) values ('00000012', 'P-59“空中彗星”战斗机', '飞行器', '战斗机','11111111');
insert into `category` (id, name, dalei, leibie, model_id) values ('00000013', 'P-39“空中眼镜蛇', '飞行器', '战斗机','11111111');
insert into `category` (id, name, dalei, leibie, model_id) values ('00000014', '波音PW-9单座单发双翼战斗机', '飞行器', '战斗机','11111111');
insert into `category` (id, name, dalei, leibie, model_id) values ('00000015', '贝尔P-63“眼镜蛇王”单翼战斗机', '飞行器', '战斗机','11111111');

# 三自由度仿真模型--和用户绑定
-- 组件模型
drop table if exists `component`;
create table `component` (
  `id` char(8) not null default '' comment 'id',
  `name` varchar(100) comment '文件名',
  `url` varchar(100) comment '地址',
  `size` int comment '大小|字节b',
  `model_id` char(8) comment '模型库|model.id',
  `category_id` char(8) comment '型号|category.id',
  `created_at` datetime(3) comment '创建时间',
  `updated_at` datetime(3) comment '修改时间',
  primary key (`id`)
) engine=innodb default charset=utf8mb4 comment='组件';
insert into `component` (id, name, category_id) values ('00000000', '三自由度机动模型','00000000');
insert into `component` (id, name, category_id) values ('00000001', '五自由度机动模型','00000000');
insert into `component` (id, name, category_id) values ('00000002', '六自由度机动模型','00000000');
-- 模型内容
-- 模型内容文件