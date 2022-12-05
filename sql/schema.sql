use food_datacenter;

DROP TABLE IF EXISTS language;
CREATE TABLE language (
  id           bigint(20) unsigned AUTO_INCREMENT NOT NULL COMMENT '主键ID', 
  create_time  datetime                           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间', 
  update_time  datetime                           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间', 
  creator_id   varchar(255)                       NOT NULL COMMENT '创建人标识',  
  modifier_id  varchar(255)                       NOT NULL COMMENT '修改人标识', 
  deleted      tinyint(1)                         NOT NULL DEFAULT 0 COMMENT '是否删除：0-否 1-是', 
  code         varchar(255)                       NOT NULL COMMENT '编码', 
  name         varchar(255)                       NOT NULL COMMENT '名字', 
  display_name varchar(255)                       NOT NULL COMMENT '展示名字', 
  description  varchar(1000)                      DEFAULT NULL COMMENT '描述', 
  PRIMARY KEY (id), 
  KEY idx_creator_id(creator_id), 
  KEY idx_modifier_id(modifier_id), 
  UNIQUE KEY uniq_code(code),
  KEY idx_name(name), 
  KEY idx_display_name(display_name)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT = '语言表';

DROP TABLE IF EXISTS channel;
CREATE TABLE channel (
  id                    bigint(20) unsigned AUTO_INCREMENT NOT NULL COMMENT '主键ID',
  create_time           datetime                           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  update_time           datetime                           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  creator_id            varchar(255)                       NOT NULL COMMENT '创建人标识',
  modifier_id           varchar(255)                       NOT NULL COMMENT '修改人标识',
  deleted               tinyint(1)                         NOT NULL DEFAULT 0 COMMENT '是否删除：0-否 1-是',
  code                  varchar(255)                       NOT NULL COMMENT '编码',
  default_language_code varchar(255)                       NOT NULL COMMENT '默认语言',
  name                  varchar(255)                       NOT NULL COMMENT '名字',
  description           varchar(1000)                      DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (id),
  KEY idx_creator_id(creator_id),
  KEY idx_modifier_id(modifier_id),
  UNIQUE KEY uniq_code(code),
  KEY idx_default_language_code(default_language_code),
  KEY idx_name(name)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT = '渠道表';

DROP TABLE IF EXISTS channel_language;
CREATE TABLE channel_language (
  id            bigint(20) unsigned AUTO_INCREMENT NOT NULL COMMENT '主键ID',
  create_time   datetime                           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  update_time   datetime                           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  creator_id    varchar(255)                       NOT NULL COMMENT '创建人标识',
  modifier_id   varchar(255)                       NOT NULL COMMENT '修改人标识',
  deleted       tinyint(1)                         NOT NULL DEFAULT 0 COMMENT '是否删除：0-否 1-是',
  channel_id    bigint(20)                         NOT NULL COMMENT '渠道ID',
  language_code varchar(255)                       NOT NULL COMMENT '语言编码',
  name          varchar(255)                       NOT NULL COMMENT '名字',
  description   varchar(1000)                      DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (id),
  KEY idx_creator_id(creator_id),
  KEY idx_modifier_id(modifier_id),
  KEY idx_channel_id(channel_id),
  KEY idx_language_code(language_code),
  KEY idx_name(name)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT = '渠道语言表';

DROP TABLE IF EXISTS food;
CREATE TABLE food (
  id                       bigint(20) unsigned AUTO_INCREMENT NOT NULL COMMENT '主键ID', 
  create_time              datetime                           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间', 
  update_time              datetime                           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间', 
  creator_id               varchar(255)                       NOT NULL COMMENT '创建人标识',  
  modifier_id              varchar(255)                       NOT NULL COMMENT '修改人标识', 
  deleted                  tinyint(1)                         NOT NULL DEFAULT 0 COMMENT '是否删除：0-否 1-是', 
  channel_id               bigint(20)                         NOT NULL COMMENT '渠道ID', 
  code                     varchar(255)                       NOT NULL COMMENT '食物编码', 
  name                     varchar(500)                       NOT NULL COMMENT '名字', 
  description              varchar(1000)                      DEFAULT NULL COMMENT '描述', 
  category_id              bigint(20)                         NOT NULL COMMENT '分类ID', 
  type_id                  bigint(20)                         NOT NULL COMMENT '类型ID', 
  serving                  varchar(255)                       NOT NULL COMMENT '份数', 
  serving_value            decimal(15, 5)                     NOT NULL COMMENT '份数对应的数值', 
  serving_unit_id          bigint(20)                         NOT NULL COMMENT '份数单位ID', 
  serving_amount           decimal(15, 5)                     NOT NULL COMMENT '份的量', 
  serving_amount_unit_code varchar(255)                       NOT NULL COMMENT '份的量的单位编码', 
  source_id                bigint(20)                         NOT NULL COMMENT '来源ID', 
  source_code              varchar(255)                       DEFAULT NULL COMMENT '来源编号', 
  branded                  tinyint(1)                         NOT NULL DEFAULT 0 COMMENT '是否是品牌食物：0-否 1-是', 
  PRIMARY KEY (id), 
  KEY idx_creator_id(creator_id), 
  KEY idx_modifier_id(modifier_id), 
  KEY idx_channel_id(channel_id),
  UNIQUE KEY uniq_code(code),
  KEY idx_name(name), 
  KEY idx_category_id(category_id),
  KEY idx_type_id(type_id),
  KEY idx_serving_unit_id(serving_unit_id),
  KEY idx_source_id(source_id)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT = '食物表';

DROP TABLE IF EXISTS food_language;
CREATE TABLE food_language (
  id            bigint(20) unsigned AUTO_INCREMENT NOT NULL COMMENT '主键ID', 
  create_time   datetime                           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间', 
  update_time   datetime                           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间', 
  creator_id    varchar(255)                       NOT NULL COMMENT '创建人标识',  
  modifier_id   varchar(255)                       NOT NULL COMMENT '修改人标识', 
  deleted       tinyint(1)                         NOT NULL DEFAULT 0 COMMENT '是否删除：0-否 1-是', 
  food_id       bigint(20)                         NOT NULL COMMENT '食物ID', 
  language_code varchar(255)                       NOT NULL COMMENT '语言编码', 
  name          varchar(255)                       NOT NULL COMMENT '名字', 
  description   varchar(1000)                      DEFAULT NULL COMMENT '描述', 
  PRIMARY KEY (id), 
  KEY idx_creator_id(creator_id), 
  KEY idx_modifier_id(modifier_id), 
  KEY idx_food_id(food_id),
  KEY idx_language_code(language_code),
  KEY idx_name(name)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT = '食物语言表';

DROP TABLE IF EXISTS brand;
CREATE TABLE brand (
  id             bigint(20) unsigned AUTO_INCREMENT NOT NULL COMMENT '主键ID', 
  create_time    datetime                           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间', 
  update_time    datetime                           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间', 
  creator_id     varchar(255)                       NOT NULL COMMENT '创建人标识', 
  modifier_id    varchar(255)                       NOT NULL COMMENT '修改人标识', 
  deleted        tinyint(1)                         NOT NULL DEFAULT 0 COMMENT '是否删除：0-否 1-是', 
  channel_id     bigint(20)                         NOT NULL COMMENT '渠道ID', 
  code           varchar(255)                       NOT NULL COMMENT '编码', 
  name           varchar(255)                       NOT NULL COMMENT '名字', 
  brand_owner_id bigint(20)                         NOT NULL COMMENT '品牌所有者ID', 
  PRIMARY KEY (id), 
  KEY idx_creator_id(creator_id), 
  KEY idx_modifier_id(modifier_id), 
  KEY idx_channel_id(channel_id), 
  UNIQUE KEY uniq_code(code),
  KEY idx_name(name), 
  KEY idx_brand_owner_id(brand_owner_id)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT = '品牌表';

DROP TABLE IF EXISTS brand_language;
CREATE TABLE brand_language (
  id            bigint(20) unsigned AUTO_INCREMENT NOT NULL COMMENT '主键ID', 
  create_time   datetime                           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间', 
  update_time   datetime                           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间', 
  creator_id    varchar(255)                       NOT NULL COMMENT '创建人标识',  
  modifier_id   varchar(255)                       NOT NULL COMMENT '修改人标识', 
  deleted       tinyint(1)                         NOT NULL DEFAULT 0 COMMENT '是否删除：0-否 1-是', 
  brand_id      bigint(20)                         NOT NULL COMMENT '品牌ID', 
  language_code varchar(255)                       NOT NULL COMMENT '语言编码', 
  name          varchar(255)                       NOT NULL COMMENT '名字', 
  PRIMARY KEY (id), 
  KEY idx_creator_id(creator_id), 
  KEY idx_modifier_id(modifier_id), 
  KEY idx_brand_id(brand_id),
  KEY idx_language_code(language_code),
  KEY idx_name(name)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT = '品牌语言表';

DROP TABLE IF EXISTS brand_owner;
CREATE TABLE brand_owner (
  id          bigint(20) unsigned AUTO_INCREMENT NOT NULL COMMENT '主键ID', 
  create_time datetime                           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间', 
  update_time datetime                           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间', 
  creator_id  varchar(255)                       NOT NULL COMMENT '创建人标识',  
  modifier_id varchar(255)                       NOT NULL COMMENT '修改人标识', 
  deleted     tinyint(1)                         NOT NULL DEFAULT 0 COMMENT '是否删除：0-否 1-是', 
  channel_id  bigint(20)                         NOT NULL COMMENT '渠道ID', 
  code        varchar(255)                       NOT NULL COMMENT '编码', 
  name        varchar(255)                       NOT NULL COMMENT '名字', 
  PRIMARY KEY (id), 
  KEY idx_creator_id(creator_id), 
  KEY idx_modifier_id(modifier_id), 
  KEY idx_channel_id(channel_id),
  UNIQUE KEY uniq_code(code),
  KEY idx_name(name)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT = '品牌所有者';

DROP TABLE IF EXISTS brand_owner_language;
CREATE TABLE brand_owner_language (
  id             bigint(20) unsigned AUTO_INCREMENT NOT NULL COMMENT '主键ID', 
  create_time    datetime                           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间', 
  update_time    datetime                           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间', 
  creator_id     varchar(255)                       NOT NULL COMMENT '创建人标识',  
  modifier_id    varchar(255)                       NOT NULL COMMENT '修改人标识', 
  deleted        tinyint(1)                         NOT NULL DEFAULT 0 COMMENT '是否删除：0-否 1-是', 
  brand_owner_id bigint(20)                         NOT NULL COMMENT '品牌所有者ID', 
  language_code  varchar(255)                       NOT NULL COMMENT '语言编码', 
  name           varchar(255)                       NOT NULL COMMENT '名字', 
  PRIMARY KEY (id), 
  KEY idx_creator_id(creator_id), 
  KEY idx_modifier_id(modifier_id), 
  KEY idx_brand_owner_id(brand_owner_id),
  KEY idx_language_code(language_code),
  KEY idx_name(name)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT = '品牌所有者语言表';

DROP TABLE IF EXISTS category;
CREATE TABLE category (
  id          bigint(20) unsigned AUTO_INCREMENT NOT NULL COMMENT '主键ID', 
  create_time datetime                           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间', 
  update_time datetime                           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间', 
  creator_id  varchar(255)                       NOT NULL COMMENT '创建人标识',  
  modifier_id varchar(255)                       NOT NULL COMMENT '修改人标识', 
  deleted     tinyint(1)                         NOT NULL DEFAULT 0 COMMENT '是否删除：0-否 1-是', 
  channel_id  bigint(20)                         NOT NULL COMMENT '渠道ID', 
  code        varchar(255)                       NOT NULL COMMENT '编码', 
  name        varchar(255)                       NOT NULL COMMENT '名字', 
  description varchar(1000)                      DEFAULT NULL COMMENT '描述', 
  PRIMARY KEY (id), 
  KEY idx_creator_id(creator_id), 
  KEY idx_modifier_id(modifier_id), 
  KEY idx_channel_id(channel_id),
  UNIQUE KEY uniq_code(code),
  KEY idx_name(name)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT = '分类表';

DROP TABLE IF EXISTS category_language;
CREATE TABLE category_language (
  id            bigint(20) unsigned AUTO_INCREMENT NOT NULL COMMENT '主键ID', 
  create_time   datetime                           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间', 
  update_time   datetime                           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间', 
  creator_id    varchar(255)                       NOT NULL COMMENT '创建人标识',  
  modifier_id   varchar(255)                       NOT NULL COMMENT '修改人标识', 
  deleted       tinyint(1)                         NOT NULL DEFAULT 0 COMMENT '是否删除：0-否 1-是', 
  category_id   bigint(20)                         NOT NULL COMMENT '分类ID', 
  language_code varchar(255)                       NOT NULL COMMENT '语言编码', 
  name          varchar(255)                       NOT NULL COMMENT '名字', 
  description   varchar(1000)                      DEFAULT NULL COMMENT '描述', 
  PRIMARY KEY (id), 
  KEY idx_creator_id(creator_id), 
  KEY idx_modifier_id(modifier_id), 
  KEY idx_category_id(category_id),
  KEY idx_language_code(language_code),
  KEY idx_name(name)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT = '分类语言表';

DROP TABLE IF EXISTS food_brand;
CREATE TABLE food_brand (
  id              bigint(20) unsigned AUTO_INCREMENT NOT NULL COMMENT '主键ID', 
  create_time     datetime                           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间', 
  update_time     datetime                           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间', 
  creator_id      varchar(255)                       NOT NULL COMMENT '创建人标识',  
  modifier_id     varchar(255)                       NOT NULL COMMENT '修改人标识', 
  deleted         tinyint(1)                         NOT NULL DEFAULT 0 COMMENT '是否删除：0-否 1-是', 
  food_id         bigint(20)                         NOT NULL COMMENT '食物ID', 
  brand_id        bigint(20)                         NOT NULL COMMENT '品牌ID', 
  package_weight  varchar(255)                       DEFAULT NULL COMMENT '包装重量', 
  package_serving decimal(15, 5)                     DEFAULT NULL COMMENT '包装所含的份数', 
  product_code    varchar(255)                       DEFAULT NULL COMMENT '品牌编码', 
  PRIMARY KEY (id), 
  KEY idx_creator_id(creator_id), 
  KEY idx_modifier_id(modifier_id), 
  UNIQUE KEY uniq_food_id(food_id),
  KEY idx_brand_id(brand_id)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT = '食物品牌表';

DROP TABLE IF EXISTS food_image;
CREATE TABLE food_image (
  id          bigint(20) unsigned AUTO_INCREMENT NOT NULL COMMENT '主键ID', 
  create_time datetime                           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间', 
  update_time datetime                           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间', 
  creator_id  varchar(255)                       NOT NULL COMMENT '创建人标识',  
  modifier_id varchar(255)                       NOT NULL COMMENT '修改人标识', 
  deleted     tinyint(1)                         NOT NULL DEFAULT 0 COMMENT '是否删除：0-否 1-是', 
  food_id     bigint(20)                         NOT NULL COMMENT '食物ID', 
  url         varchar(1000)                      NOT NULL COMMENT '链接', 
  `order`     int(10)                            NOT NULL COMMENT '顺序',
  PRIMARY KEY (id), 
  KEY idx_creator_id(creator_id), 
  KEY idx_modifier_id(modifier_id), 
  KEY idx_food_id(food_id),
  KEY idx_order(`order`)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT = '食物图片表';

DROP TABLE IF EXISTS food_ingredient;
CREATE TABLE food_ingredient (
  id                 bigint(20) unsigned AUTO_INCREMENT NOT NULL COMMENT '主键ID', 
  create_time        datetime                           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间', 
  update_time        datetime                           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间', 
  creator_id         varchar(255)                       NOT NULL COMMENT '创建人标识',  
  modifier_id        varchar(255)                       NOT NULL COMMENT '修改人标识', 
  deleted            tinyint(1)                         NOT NULL DEFAULT 0 COMMENT '是否删除：0-否 1-是', 
  food_id            bigint(20)                         NOT NULL COMMENT '食物ID', 
  ingredient_food_id bigint(20)                         NOT NULL COMMENT '原材料食物ID', 
  serving            varchar(255)                       NOT NULL COMMENT '份数', 
  serving_value      decimal(15, 5)                     NOT NULL COMMENT '份数的值', 
  PRIMARY KEY (id), 
  KEY idx_creator_id(creator_id), 
  KEY idx_modifier_id(modifier_id), 
  KEY idx_food_id(food_id),
  KEY idx_ingredient_food_id(ingredient_food_id)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT = '食物组成表';

DROP TABLE IF EXISTS food_nutrient;
CREATE TABLE food_nutrient (
  id             bigint(20) unsigned AUTO_INCREMENT NOT NULL COMMENT '主键ID', 
  create_time    datetime                           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间', 
  update_time    datetime                           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间', 
  creator_id     varchar(255)                       NOT NULL COMMENT '创建人标识',  
  modifier_id    varchar(255)                       NOT NULL COMMENT '修改人标识', 
  deleted        tinyint(1)                         NOT NULL DEFAULT 0 COMMENT '是否删除：0-否 1-是', 
  food_id        bigint(20)                         NOT NULL COMMENT '食物ID', 
  nutrient_id    bigint(20)                         NOT NULL COMMENT '营养元素ID', 
  package_weight decimal(15, 5)                     NOT NULL COMMENT '营养元素值', 
  unit_id        varchar(255)                       NOT NULL COMMENT '单位ID', 
  PRIMARY KEY (id), 
  KEY idx_creator_id(creator_id), 
  KEY idx_modifier_id(modifier_id), 
  UNIQUE KEY uniq_food_id(food_id),
  KEY idx_nutrient_id(nutrient_id)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT = '食物营养成份表';

DROP TABLE IF EXISTS nutrient;
CREATE TABLE nutrient (
  id           bigint(20) unsigned AUTO_INCREMENT NOT NULL COMMENT '主键ID', 
  create_time  datetime                           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间', 
  update_time  datetime                           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间', 
  creator_id   varchar(255)                       NOT NULL COMMENT '创建人标识',  
  modifier_id  varchar(255)                       NOT NULL COMMENT '修改人标识', 
  deleted      tinyint(1)                         NOT NULL DEFAULT 0 COMMENT '是否删除：0-否 1-是', 
  channel_id   bigint(20)                         NOT NULL COMMENT '渠道ID', 
  code         varchar(255)                       NOT NULL COMMENT '编码', 
  name         varchar(255)                       NOT NULL COMMENT '名字', 
  description  varchar(1000)                      DEFAULT NULL COMMENT '描述', 
  display_name varchar(255)                       NOT NULL COMMENT '展示名字', 
  abbreviation varchar(255)                       DEFAULT NULL COMMENT '缩写', 
  `order`      int(10)                            NOT NULL COMMENT '顺序',
  PRIMARY KEY (id), 
  KEY idx_creator_id(creator_id), 
  KEY idx_modifier_id(modifier_id), 
  KEY idx_channel_id(channel_id),
  UNIQUE KEY uniq_code(code),
  KEY idx_name(name)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT = '营养成份表';

DROP TABLE IF EXISTS nutrient_language;
CREATE TABLE nutrient_language (
  id            bigint(20) unsigned AUTO_INCREMENT NOT NULL COMMENT '主键ID', 
  create_time   datetime                           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间', 
  update_time   datetime                           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间', 
  creator_id    varchar(255)                       NOT NULL COMMENT '创建人标识',  
  modifier_id   varchar(255)                       NOT NULL COMMENT '修改人标识', 
  deleted       tinyint(1)                         NOT NULL DEFAULT 0 COMMENT '是否删除：0-否 1-是', 
  nutrient_id   bigint(20)                         NOT NULL COMMENT '营养元素ID', 
  language_code varchar(255)                       NOT NULL COMMENT '语言编码', 
  name          varchar(255)                       NOT NULL COMMENT '名字', 
  description   varchar(1000)                      DEFAULT NULL COMMENT '描述', 
  display_name  varchar(255)                       NOT NULL COMMENT '展示名字', 
  abbreviation  varchar(255)                       DEFAULT NULL COMMENT '缩写', 
  PRIMARY KEY (id), 
  KEY idx_creator_id(creator_id), 
  KEY idx_modifier_id(modifier_id), 
  KEY idx_nutrient_id(nutrient_id),
  KEY idx_language_code(language_code),
  KEY idx_name(name)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT = '营养成分语言表';

DROP TABLE IF EXISTS source;
CREATE TABLE source (
  id          bigint(20) unsigned AUTO_INCREMENT NOT NULL COMMENT '主键ID', 
  create_time datetime                           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间', 
  update_time datetime                           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间', 
  creator_id  varchar(255)                       NOT NULL COMMENT '创建人标识',  
  modifier_id varchar(255)                       NOT NULL COMMENT '修改人标识', 
  deleted     tinyint(1)                         NOT NULL DEFAULT 0 COMMENT '是否删除：0-否 1-是', 
  channel_id  bigint(20)                         NOT NULL COMMENT '渠道ID', 
  code        varchar(255)                       NOT NULL COMMENT '编码', 
  name        varchar(255)                       NOT NULL COMMENT '名字', 
  description varchar(1000)                      DEFAULT NULL COMMENT '描述', 
  url         varchar(255)                       DEFAULT NULL COMMENT '链接', 
  PRIMARY KEY (id), 
  KEY idx_creator_id(creator_id), 
  KEY idx_modifier_id(modifier_id), 
  KEY idx_channel_id(channel_id),
  UNIQUE KEY uniq_code(code),
  KEY idx_name(name)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT = '来源表';

DROP TABLE IF EXISTS source_language;
CREATE TABLE source_language (
  id            bigint(20) unsigned AUTO_INCREMENT NOT NULL COMMENT '主键ID', 
  create_time   datetime                           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间', 
  update_time   datetime                           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间', 
  creator_id    varchar(255)                       NOT NULL COMMENT '创建人标识',  
  modifier_id   varchar(255)                       NOT NULL COMMENT '修改人标识', 
  deleted       tinyint(1)                         NOT NULL DEFAULT 0 COMMENT '是否删除：0-否 1-是', 
  source_id     bigint(20)                         NOT NULL COMMENT '来源ID', 
  language_code varchar(255)                       NOT NULL COMMENT '语言编码', 
  name          varchar(255)                       NOT NULL COMMENT '名字', 
  description   varchar(1000)                      DEFAULT NULL COMMENT '描述', 
  PRIMARY KEY (id), 
  KEY idx_creator_id(creator_id), 
  KEY idx_modifier_id(modifier_id), 
  KEY idx_source_id(source_id),
  KEY idx_language_code(language_code),
  KEY idx_name(name)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT = '来源语言表';

DROP TABLE IF EXISTS unit;
CREATE TABLE unit (
  id           bigint(20) unsigned AUTO_INCREMENT NOT NULL COMMENT '主键ID', 
  create_time  datetime                           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间', 
  update_time  datetime                           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间', 
  creator_id   varchar(255)                       NOT NULL COMMENT '创建人标识',  
  modifier_id  varchar(255)                       NOT NULL COMMENT '修改人标识', 
  deleted      tinyint(1)                         NOT NULL DEFAULT 0 COMMENT '是否删除：0-否 1-是', 
  channel_id   bigint(20)                         NOT NULL COMMENT '渠道ID', 
  code         varchar(255)                       NOT NULL COMMENT '编码', 
  type         int(10)                            NOT NULL COMMENT '类型：1-serving unit 2-measure unit', 
  name         varchar(255)                       NOT NULL COMMENT '名字', 
  description  varchar(1000)                      DEFAULT NULL COMMENT '描述', 
  display_name varchar(255)                       NOT NULL COMMENT '展示名字', 
  abbreviation varchar(255)                       DEFAULT NULL COMMENT '缩写', 
  PRIMARY KEY (id), 
  KEY idx_creator_id(creator_id), 
  KEY idx_modifier_id(modifier_id), 
  KEY idx_channel_id(channel_id),
  UNIQUE KEY uniq_code(code),
  KEY idx_name(name)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT = '单位表';

DROP TABLE IF EXISTS unit_language;
CREATE TABLE unit_language (
  id            bigint(20) unsigned AUTO_INCREMENT NOT NULL COMMENT '主键ID', 
  create_time   datetime                           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间', 
  update_time   datetime                           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间', 
  creator_id    varchar(255)                       NOT NULL COMMENT '创建人标识',  
  modifier_id   varchar(255)                       NOT NULL COMMENT '修改人标识', 
  deleted       tinyint(1)                         NOT NULL DEFAULT 0 COMMENT '是否删除：0-否 1-是', 
  unit_id       bigint(20)                         NOT NULL COMMENT '单位ID', 
  language_code varchar(255)                       NOT NULL COMMENT '语言编码', 
  name          varchar(255)                       NOT NULL COMMENT '名字', 
  description   varchar(1000)                      DEFAULT NULL COMMENT '描述', 
  display_name  varchar(255)                       NOT NULL COMMENT '展示名字', 
  abbreviation  varchar(255)                       DEFAULT NULL COMMENT '缩写', 
  PRIMARY KEY (id), 
  KEY idx_creator_id(creator_id), 
  KEY idx_modifier_id(modifier_id), 
  KEY idx_unit_id(unit_id),
  KEY idx_language_code(language_code),
  KEY idx_name(name)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT = '单位语言表';

DROP TABLE IF EXISTS system_configuration;
CREATE TABLE system_configuration (
  id                  bigint(20) unsigned AUTO_INCREMENT NOT NULL COMMENT '自增主键', 
  create_time         datetime                           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间', 
  update_time         datetime                           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间', 
  creator_id          varchar(255)                       NOT NULL COMMENT '创建人ID', 
  modifier_id         varchar(255)                       NOT NULL COMMENT '修改人ID', 
  deleted             tinyint(1)                         NOT NULL DEFAULT 0 COMMENT '是否已删除：0-未删除 1-已删除', 
  channel_id          bigint(20)                         NOT NULL COMMENT '渠道ID', 
  enable_search       tinyint(1)                         NOT NULL DEFAULT 0 COMMENT '是否使用搜索服务：0-否 1-是', 
  search_service_name varchar(255)                       DEFAULT NULL COMMENT '搜索服务名', 
  PRIMARY KEY (id), 
  KEY idx_creator_id(creator_id), 
  KEY idx_modifier_id(modifier_id), 
  UNIQUE KEY uniq_channel_id(channel_id)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT = '系统配置';

DROP TABLE IF EXISTS search_configuration;
CREATE TABLE search_configuration (
  id                  bigint(20) unsigned AUTO_INCREMENT NOT NULL COMMENT '自增主键', 
  create_time         datetime                           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间', 
  update_time         datetime                           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间', 
  creator_id          varchar(255)                       NOT NULL COMMENT '创建人ID', 
  modifier_id         varchar(255)                       NOT NULL COMMENT '修改人ID', 
  deleted             tinyint(1)                         NOT NULL DEFAULT 0 COMMENT '是否已删除：0-未删除 1-已删除', 
  channel_id          bigint(20)                         NOT NULL COMMENT '渠道ID', 
  enable_search       tinyint(1)                         NOT NULL DEFAULT 0 COMMENT '是否使用搜索服务：0-否 1-是', 
  search_service_name varchar(255)                       DEFAULT NULL COMMENT '搜索服务名', 
  PRIMARY KEY (id), 
  KEY idx_creator_id(creator_id), 
  KEY idx_modifier_id(modifier_id), 
  UNIQUE KEY uniq_channel_id(channel_id)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COMMENT = '系统配置';