create table member
(
    id           bigint auto_increment comment '회원_고유번호',
    name         varchar(255)           not null comment '이름',
    email        varchar(255)           not null comment '로그인_이메일',
    password     varchar(255)           not null comment '로그인_비밀번호',
    phone_number varchar(255)           not null comment '전화번호',
    address      varchar(255) comment '집주소',
    role         enum ('USER', 'ADMIN') not null default 'user' comment '권한',

    constraint member_pk primary key (id)
);

create table category
(
    id   bigint auto_increment comment '카테고리_고유번호',
    name varchar(255) not null comment '카테고리_이름',

    constraint category_fk primary key (id)
);

create table product
(
    id             bigint auto_increment comment '제품_고유번호',
    name           varchar(255) not null comment '제품이름',
    cnt            int          not null default 0 comment '제품수량',
    main_image     varchar(255),
    price          int          not null default 0 comment '제품 가격',
    description    longtext comment '제품설명',
    category_fk_id bigint       not null comment '카테고리_fk',

    constraint product_fk primary key (id),
    constraint product_category_fk foreign key (category_fk_id) references category (id)
);

create table cart
(
    id           bigint auto_increment comment '카트_고유번호',
    member_fk_id bigint comment '회원_고유번호_fk',

    constraint cart_id primary key (id),
    constraint cart_member_fk foreign key (member_fk_id) references member (id)
) comment '각 회원고유번호를 가지고 카트 고유번호 생성 하고 cart_product 연결';

create table cart_product
(
    id            bigint auto_increment comment '카트_제품_고유번호',
    product_fk_id bigint comment '제품_fk',
    cart_fk_id    bigint comment '카트_fk',
    product_cnt   int comment '제품_수량',

    constraint cart_product_id primary key (id),
    constraint cart_product_cart_fk foreign key (cart_fk_id) references cart (id),
    constraint cart_product_product_fk foreign key (product_fk_id) references product (id)
);

create table orders_number_generator
(
    id        bigint auto_increment comment '주문_고유번호',
    member_fk_id bigint comment '회원_고유번호_fk',
    delivery_status  enum ('ORDERED','READY','DELIVERED') comment '배송상태',

    constraint orders_id primary key (id),
    constraint orders_number_generator_member_fk foreign key (member_fk_id) references member (id)
);

create table orders_product
(
    id            bigint auto_increment comment '주문_제품_고유번호',
    product_fk_id bigint comment '제품_fk',
    orders_number_generator_fk_id  bigint comment '주문번호_fk',
    product_cnt   int comment '제품_수량',

    constraint orders_product_id primary key (id),
    constraint orders_product_product_fk foreign key (product_fk_id) references product (id),
    constraint orders_product_orders_fk foreign key (orders_number_generator_fk_id) references orders_number_generator (id)
);

create table review
(
    id            bigint auto_increment comment '리뷰_고유번호',
    product_fk_id bigint       not null comment '제품_fk',
    member_fk_id  bigint       not null comment '회원_fk',
    star          int          not null comment '상품_리뷰_별',
    content       varchar(255) not null comment '상품_리뷰',

    constraint review_id primary key (id),
    constraint review_product_fk foreign key (product_fk_id) references product (id),
    constraint review_member_fk foreign key (member_fk_id) references member (id)
);

