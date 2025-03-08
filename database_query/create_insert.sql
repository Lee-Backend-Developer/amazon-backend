insert member (name, phone_number, address, role)
    value('어드민', '010-0000-0000', '경기도 안성시', 'admin');

insert product(name, cnt, main_image, price, description)
    value ('Amazon Basics PC에서 스트리밍, 녹음 및 팟캐스트를 위한 USB 콘덴서 마이크, 플러그 앤 플레이, 카디오이드 픽업, 360° 회전이 가능한 조절 가능한 스탠드, 14.7 x 8.6cm(5.8 x 3.4인치), 블랙',
           10, 'test.jpg', 35000, '이것은 마이크 입니다');


insert cart(product_fk, product_cnt, member_fk)
    value (1, 2, 1);

insert category(name, product_fk)
    value('마이크', 1);
