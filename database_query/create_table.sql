create table member
(
    id           bigint auto_increment comment '회원_고유번호',
    name         varchar(255)           not null comment '이름',
    phone_number varchar(255)           not null comment '전화번호',
    address      varchar(255) comment '집주소',
    role         enum ('user', 'admin') not null default 'user' comment '권한',

    constraint member_pk primary key (id)
);

create table product
(
    id          bigint auto_increment comment '제품_고유번호',
    name        varchar(255) not null comment '제품이름',
    cnt         int          not null default 0 comment '제품수량',
    main_image  varchar(255),
    price       int          not null default 0 comment '제품 가격',
    description longtext comment '제품설명',

    constraint product_fk primary key (id)
);

create table cart
(
    id              bigint auto_increment comment '카트_고유번호',
    member_fk_id       bigint comment '회원_고유번호_fk',

    constraint cart_id primary key (id),
    constraint cart_member_fk foreign key (member_fk_id) references member (id)
);

create table cart_product
(
    id          bigint auto_increment comment '카트_제품_고유번호',
    product_fk_id  bigint comment '제품_fk',
    cart_fk_id     bigint comment '카트_fk',
    product_cnt int comment '제품_수량',

    constraint cart_product_id primary key (id),
    constraint cart_product_cart_fk foreign key (cart_fk_id) references cart (id),
    constraint cart_product_product_fk foreign key (product_fk_id) references product (id)
);

create table orders
(
    id          bigint auto_increment comment '주문_고유번호',
    cart_fk_id     bigint comment '카트_fk',
    member_fk_id   bigint comment '회원_fk',
    product_cnt int comment '제품_수량',

    constraint orders_id primary key (id),
    constraint orders_product_fk foreign key (cart_fk_id) references product (id),
    constraint orders_member_fk foreign key (member_fk_id) references member (id)
);

create table delivery
(
    id        bigint auto_increment comment '배송_고유번호',
    member_fk_id bigint comment '회원_fk',
    orders_fk_id bigint comment '주문_fk',
    state     enum ('ordered','ready','delivered'),

    constraint delivery_id primary key (id),
    constraint delivery_member_fk foreign key (member_fk_id) references member (id),
    constraint delevery_order_fk foreign key (orders_fk_id) references orders (id)
);

create table category
(
    id         bigint auto_increment comment '카테고리_고유번호',
    name       varchar(255) not null comment '카테고리_이름',
    product_fk_id bigint          not null comment '제품_fk',

    constraint category_fk primary key (id),
    constraint category_product_fk foreign key (product_fk_id) references product (id)
);

create table review
(
    id         bigint auto_increment comment '리뷰_고유번호',
    product_fk_id bigint          not null comment '제품_fk',
    member_fk_id  bigint          not null comment '회원_fk',
    star       int          not null comment '상품_리뷰_별',
    content    varchar(255) not null comment '상품_리뷰',

    constraint review_id primary key (id),
    constraint review_product_fk foreign key (product_fk_id) references product (id),
    constraint review_member_fk foreign key (member_fk_id) references member (id)
);

