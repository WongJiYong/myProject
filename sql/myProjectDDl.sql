CREATE TABLE action
(
    id      bigint AUTO_INCREMENT COMMENT 'ID'
        PRIMARY KEY,
    name    varchar(255)         NULL COMMENT '按钮功能（增删改查）',
    menu_id bigint               NOT NULL COMMENT '菜单ID',
    sort    bigint               NULL COMMENT '排序',
    icon    varchar(255)         NULL COMMENT '图标',
    path    varchar(255)         NULL COMMENT '该地址用来控制请求权限',
    locked  tinyint(1) DEFAULT 0 NULL COMMENT '锁定（页面显示但是不能用）',
    enabled tinyint(1) DEFAULT 1 NULL COMMENT '启用（页面不显示）',
    deleted tinyint(1) DEFAULT 0 NOT NULL COMMENT '逻辑删除位',
    version int        DEFAULT 0 NOT NULL COMMENT '版本号'
)
    COMMENT '菜单内按钮';

CREATE INDEX FKqcf9gem97gqa5qjm4d3elcqt5
    ON action (menu_id);

CREATE TABLE catalog
(
    id        int AUTO_INCREMENT COMMENT '主键'
        PRIMARY KEY,
    name      varchar(20)          NULL COMMENT '目录名',
    type      varchar(20)          NULL COMMENT '类型',
    parent_id int                  NULL COMMENT '父目录id',
    seq       int                  NULL COMMENT '顺序',
    deleted   tinyint(1) DEFAULT 0 NOT NULL COMMENT '逻辑删除位',
    version   int        DEFAULT 0 NOT NULL COMMENT '版本号'
)
    COMMENT '目录';

CREATE TABLE dept
(
    id          bigint AUTO_INCREMENT COMMENT 'ID'
        PRIMARY KEY,
    name        varchar(255)         NOT NULL COMMENT '名称',
    pid         bigint               NOT NULL COMMENT '上级部门',
    enabled     bit                  NOT NULL COMMENT '状态',
    create_time datetime             NULL COMMENT '创建日期',
    deleted     tinyint(1) DEFAULT 0 NOT NULL COMMENT '逻辑删除位',
    version     int        DEFAULT 0 NOT NULL COMMENT '版本号'
)
    COMMENT '部门';

CREATE TABLE dict
(
    id          bigint(11) AUTO_INCREMENT
        PRIMARY KEY,
    name        varchar(255)         NOT NULL COMMENT '字典名称',
    remark      varchar(255)         NULL COMMENT '描述',
    create_time datetime             NULL COMMENT '创建日期',
    deleted     tinyint(1) DEFAULT 0 NOT NULL COMMENT '逻辑删除位',
    version     int        DEFAULT 0 NOT NULL COMMENT '版本号'
)
    COMMENT '数据字典';

CREATE TABLE dict_detail
(
    id          bigint(11) AUTO_INCREMENT
        PRIMARY KEY,
    label       varchar(255)         NOT NULL COMMENT '字典标签',
    value       varchar(255)         NOT NULL COMMENT '字典值',
    sort        varchar(255)         NULL COMMENT '排序',
    dict_id     bigint(11)           NULL COMMENT '字典id',
    create_time datetime             NULL COMMENT '创建日期',
    deleted     tinyint(1) DEFAULT 0 NOT NULL COMMENT '逻辑删除位',
    version     int        DEFAULT 0 NOT NULL COMMENT '版本号'
)
    COMMENT '数据字典详情';

CREATE INDEX FK5tpkputc6d9nboxojdbgnpmyb
    ON dict_detail (dict_id);

CREATE TABLE email_config
(
    id        bigint AUTO_INCREMENT COMMENT 'ID'
        PRIMARY KEY,
    from_user varchar(255)         NULL COMMENT '收件人',
    host      varchar(255)         NULL COMMENT '邮件服务器SMTP地址',
    pass      varchar(255)         NULL COMMENT '密码',
    port      varchar(255)         NULL COMMENT '端口',
    user      varchar(255)         NULL COMMENT '发件者用户名',
    deleted   tinyint(1) DEFAULT 0 NOT NULL COMMENT '逻辑删除位',
    version   int        DEFAULT 0 NOT NULL COMMENT '版本号'
)
    COMMENT '邮箱配置';

CREATE TABLE job
(
    id          bigint AUTO_INCREMENT COMMENT 'ID'
        PRIMARY KEY,
    name        varchar(255)         NOT NULL COMMENT '岗位名称',
    enabled     bit                  NOT NULL COMMENT '岗位状态',
    sort        bigint               NOT NULL COMMENT '岗位排序',
    dept_id     bigint               NULL COMMENT '部门ID',
    create_time datetime             NULL COMMENT '创建日期',
    deleted     tinyint(1) DEFAULT 0 NOT NULL COMMENT '逻辑删除位',
    version     int        DEFAULT 0 NOT NULL COMMENT '版本号'
)
    COMMENT '岗位';

CREATE INDEX FKmvhj0rogastlctflsxf1d6k3i
    ON job (dept_id);

CREATE TABLE local_storage
(
    id          bigint AUTO_INCREMENT
        PRIMARY KEY,
    real_name   varchar(255)         NULL COMMENT '文件真实的名称',
    name        varchar(255)         NULL COMMENT '文件名',
    suffix      varchar(255)         NULL COMMENT '后缀',
    path        varchar(255)         NULL COMMENT '路径',
    type        varchar(255)         NULL COMMENT '类型',
    size        varchar(100)         NULL COMMENT '大小',
    operate     varchar(255)         NULL COMMENT '操作人',
    create_time datetime             NULL COMMENT '创建日期',
    deleted     tinyint(1) DEFAULT 0 NOT NULL COMMENT '逻辑删除位',
    version     int        DEFAULT 0 NOT NULL COMMENT '版本号'
)
    COMMENT '本地存储';

CREATE TABLE log
(
    id               bigint AUTO_INCREMENT
        PRIMARY KEY,
    create_time      datetime             NULL,
    description      varchar(255)         NULL,
    exception_detail text                 NULL,
    log_type         varchar(255)         NULL,
    method           varchar(255)         NULL,
    params           text                 NULL,
    request_ip       varchar(255)         NULL,
    time             bigint               NULL,
    username         varchar(255)         NULL,
    address          varchar(255)         NULL,
    browser          varchar(255)         NULL,
    deleted          tinyint(1) DEFAULT 0 NOT NULL COMMENT '逻辑删除位',
    version          int        DEFAULT 0 NOT NULL COMMENT '版本号'
)
    COMMENT '系统日志';

CREATE TABLE menu
(
    id             bigint AUTO_INCREMENT COMMENT 'ID'
        PRIMARY KEY,
    i_frame        bit                      NULL COMMENT '是否外链',
    name           varchar(255)             NULL COMMENT '菜单名称',
    component      varchar(255)             NULL COMMENT '组件',
    pid            bigint                   NOT NULL COMMENT '上级菜单ID',
    sort           bigint                   NULL COMMENT '排序',
    icon           varchar(255)             NULL COMMENT '图标',
    path           varchar(255)             NULL COMMENT '链接地址',
    cache          bit         DEFAULT b'0' NULL COMMENT '缓存',
    enabled        tinyint(1)  DEFAULT 1    NULL COMMENT '是否启用',
    component_name varchar(20) DEFAULT '-'  NULL COMMENT '组件名称',
    create_time    datetime                 NULL COMMENT '创建日期',
    permission     varchar(255)             NULL COMMENT '权限',
    type           int                      NULL COMMENT '类型',
    deleted        tinyint(1)  DEFAULT 0    NOT NULL COMMENT '逻辑删除位',
    version        int         DEFAULT 0    NOT NULL COMMENT '版本号'
)
    COMMENT '系统菜单';

CREATE INDEX FKqcf9gem97gqa5qjm4d3elcqt5
    ON menu (pid);

CREATE TABLE picture
(
    id          bigint AUTO_INCREMENT COMMENT 'ID'
        PRIMARY KEY,
    create_time datetime             NULL COMMENT '上传日期',
    delete_url  varchar(255)         NULL COMMENT '删除的URL',
    filename    varchar(255)         NULL COMMENT '图片名称',
    height      varchar(255)         NULL COMMENT '图片高度',
    size        varchar(255)         NULL COMMENT '图片大小',
    url         varchar(255)         NULL COMMENT '图片地址',
    username    varchar(255)         NULL COMMENT '用户名称',
    width       varchar(255)         NULL COMMENT '图片宽度',
    md5code     varchar(255)         NULL COMMENT '文件的MD5值',
    deleted     tinyint(1) DEFAULT 0 NOT NULL COMMENT '逻辑删除位',
    version     int        DEFAULT 0 NOT NULL COMMENT '版本号'
)
    COMMENT 'Sm.Ms图床';

CREATE TABLE process_info
(
    id          int AUTO_INCREMENT COMMENT '主键'
        PRIMARY KEY,
    server_id   int                  NULL COMMENT '外键',
    pid         int                  NULL COMMENT '进程pid',
    name        varchar(300)         NULL COMMENT '进程名',
    port        int                  NULL COMMENT '端口',
    detail      varchar(300)         NULL COMMENT '备注',
    root_path   varchar(300)         NULL COMMENT '根路径',
    startup_sh  varchar(300)         NULL COMMENT '启动脚本',
    shutdown_sh varchar(300)         NULL COMMENT '关闭路径',
    status      varchar(30)          NULL COMMENT '进程状态',
    deleted     tinyint(1) DEFAULT 0 NOT NULL COMMENT '逻辑删除位',
    version     int        DEFAULT 0 NOT NULL COMMENT '版本号'
);

CREATE TABLE role
(
    id          bigint AUTO_INCREMENT COMMENT 'ID'
        PRIMARY KEY,
    name        varchar(255)         NOT NULL COMMENT '名称',
    remark      varchar(255)         NULL COMMENT '备注',
    data_scope  varchar(255)         NULL COMMENT '数据权限',
    level       int(255)             NULL COMMENT '角色级别',
    create_time datetime             NULL COMMENT '创建日期',
    permission  varchar(255)         NULL COMMENT '功能权限',
    deleted     tinyint(1) DEFAULT 0 NOT NULL COMMENT '逻辑删除位',
    version     int        DEFAULT 0 NOT NULL COMMENT '版本号'
)
    COMMENT '角色表';

CREATE TABLE roles_action
(
    action_id bigint               NOT NULL COMMENT '请求ID',
    role_id   bigint               NOT NULL COMMENT '角色ID',
    deleted   tinyint(1) DEFAULT 0 NOT NULL COMMENT '逻辑删除位',
    PRIMARY KEY (action_id, role_id)
)
    COMMENT '角色按钮关联';

CREATE TABLE roles_depts
(
    role_id bigint               NOT NULL,
    dept_id bigint               NOT NULL,
    deleted tinyint(1) DEFAULT 0 NOT NULL COMMENT '逻辑删除位',
    version int        DEFAULT 0 NOT NULL COMMENT '版本号',
    PRIMARY KEY (role_id, dept_id)
)
    COMMENT '角色部门关联';

CREATE INDEX FK7qg6itn5ajdoa9h9o78v9ksur
    ON roles_depts (dept_id);

CREATE TABLE roles_menus
(
    menu_id bigint               NOT NULL COMMENT '菜单ID',
    role_id bigint               NOT NULL COMMENT '角色ID',
    deleted tinyint(1) DEFAULT 0 NOT NULL COMMENT '逻辑删除位',
    PRIMARY KEY (menu_id, role_id)
)
    COMMENT '角色菜单关联';

CREATE INDEX FKcngg2qadojhi3a651a5adkvbq
    ON roles_menus (role_id);

CREATE TABLE server_info
(
    id            int AUTO_INCREMENT COMMENT '主键'
        PRIMARY KEY,
    ip            varchar(15)          NULL COMMENT 'ip',
    name          varchar(20)          NULL COMMENT '服务器名',
    type          int                  NULL COMMENT '类型',
    detail        varchar(300)         NULL,
    username      varchar(20)          NULL COMMENT '用户名',
    password      varchar(100)         NULL COMMENT '密码',
    catalog_id    int                  NULL COMMENT '目录id',
    modified_time datetime             NULL COMMENT '最后修改时间',
    connectable   tinyint(1) DEFAULT 0 NULL COMMENT '可连接',
    mounted_on    varchar(100)         NULL COMMENT '挂载点',
    disk_total    int                  NULL COMMENT '磁盘总量',
    disk_used     int                  NULL COMMENT '磁盘已使用',
    update_time   timestamp            NULL COMMENT '更新时间',
    deleted       tinyint(1) DEFAULT 0 NOT NULL COMMENT '逻辑删除位',
    version       int        DEFAULT 0 NOT NULL COMMENT '版本号'
)
    COMMENT '服务器信息·';

CREATE TABLE user
(
    id                       bigint AUTO_INCREMENT COMMENT 'ID'
        PRIMARY KEY,
    avatar_id                bigint               NULL COMMENT '头像',
    email                    varchar(255)         NULL COMMENT '邮箱',
    password                 varchar(255)         NULL COMMENT '密码',
    username                 varchar(255)         NULL COMMENT '用户名',
    dept_id                  bigint               NULL COMMENT '部门名称',
    phone                    varchar(255)         NULL COMMENT '手机号码',
    job_id                   bigint               NULL COMMENT '岗位名称',
    create_time              datetime             NULL COMMENT '创建日期',
    last_password_reset_time datetime             NULL COMMENT '最后修改密码的日期',
    nick_name                varchar(255)         NULL,
    sex                      varchar(255)         NULL,
    deleted                  tinyint(1) DEFAULT 0 NOT NULL COMMENT '逻辑删除位',
    locked                   tinyint(1) DEFAULT 0 NULL COMMENT '是否锁定',
    enabled                  tinyint(1) DEFAULT 1 NULL COMMENT '账号是否可用',
    version                  int        DEFAULT 0 NOT NULL COMMENT '版本号',
    CONSTRAINT UK_kpubos9gc2cvtkb0thktkbkes
        UNIQUE (email),
    CONSTRAINT username
        UNIQUE (username)
)
    COMMENT '系统用户';

CREATE INDEX FK5rwmryny6jthaaxkogownknqp
    ON user (dept_id);

CREATE INDEX FKfftoc2abhot8f2wu6cl9a5iky
    ON user (job_id);

CREATE INDEX FKpq2dhypk2qgt68nauh2by22jb
    ON user (avatar_id);

CREATE TABLE user_avatar
(
    id          bigint AUTO_INCREMENT
        PRIMARY KEY,
    real_name   varchar(255)         NULL COMMENT '真实文件名',
    path        varchar(255)         NULL COMMENT '路径',
    size        varchar(255)         NULL COMMENT '大小',
    create_time datetime             NULL COMMENT '创建时间',
    deleted     tinyint(1) DEFAULT 0 NOT NULL COMMENT '逻辑删除位',
    version     int        DEFAULT 0 NOT NULL COMMENT '版本号'
)
    COMMENT '系统用户头像';

CREATE TABLE user_setting
(
    id        bigint AUTO_INCREMENT
        PRIMARY KEY,
    user_id   bigint               NULL,
    role_id   bigint               NULL COMMENT '默认角色id',
    page_size int                  NULL COMMENT '默认查询页大小',
    deleted   tinyint(1) DEFAULT 0 NOT NULL COMMENT '逻辑删除位',
    version   int        DEFAULT 0 NOT NULL COMMENT '版本号'
);

CREATE TABLE users_roles
(
    user_id bigint               NOT NULL COMMENT '用户ID',
    role_id bigint               NOT NULL COMMENT '角色ID',
    deleted tinyint(1) DEFAULT 0 NOT NULL COMMENT '逻辑删除位',
    PRIMARY KEY (user_id, role_id)
)
    COMMENT '用户角色关联';

CREATE INDEX FKq4eq273l04bpu4efj0jd0jb98
    ON users_roles (role_id);

CREATE TABLE verification_code
(
    id          bigint AUTO_INCREMENT COMMENT 'ID'
        PRIMARY KEY,
    code        varchar(255)         NULL COMMENT '验证码',
    create_time datetime             NULL COMMENT '创建日期',
    status      bit                  NULL COMMENT '状态：1有效、0过期',
    type        varchar(255)         NULL COMMENT '验证码类型：email或者短信',
    value       varchar(255)         NULL COMMENT '接收邮箱或者手机号码',
    scenes      varchar(255)         NULL COMMENT '业务名称：如重置邮箱、重置密码等',
    deleted     tinyint(1) DEFAULT 0 NOT NULL COMMENT '逻辑删除位',
    version     int        DEFAULT 0 NOT NULL COMMENT '版本号'
)
    COMMENT '验证码';


