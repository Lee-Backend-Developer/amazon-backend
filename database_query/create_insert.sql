# 회원가입 sql
insert member (name, email, password ,phone_number, address, role)
    value('어드민', 'admin@naver.com','admin','010-0000-0000', '경기도 안성시', 'admin');

# 카테고리 생성 sql
insert category(name)
    value('마이크');

# 제품 생성 sql
insert product(name, cnt, main_image, price, description, category_fk_id)
    value ('Amazon Basics PC에서 스트리밍, 녹음 및 팟캐스트를 위한 USB 콘덴서 마이크, 플러그 앤 플레이, 카디오이드 픽업, 360° 회전이 가능한 조절 가능한 스탠드, 14.7 x 8.6cm(5.8 x 3.4인치), 블랙',
           10, 'test.jpg', 35000, '이것은 마이크 입니다',2);

# 카트 생성 sql
insert cart(member_fk_id)
    value (1);

# 카트 물건 담기 sql
insert cart_product(product_fk_id, cart_fk_id, product_cnt)
    value (4, 1, 1);

