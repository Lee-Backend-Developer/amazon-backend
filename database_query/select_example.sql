# cart와 cart_product 조인하기
# 카트 ID, 회원정보, 제품명, 수량 조회
select
    c.id as '카트ID',
    (select name from member where member.id = c.member_fk_id) as '회원이름',
    (select name from product where product.id = cp.product_fk_id) as '제품명',
    cp.product_cnt as '제품수량'
    from cart c inner join cart_product cp
on c.id = cp.cart_fk_id;

# 카테고리 별 제품 가져오기
select * from product where category_fk_id = 1;

select * from cart where id = 1;
select * from cart_product;

# 주문한 상품 조회하기 쿼리
# 1. 주문번호는 하나, 주문한 상품들을 조회하기
select ong.id '주문번호', (select name from product where id = op.product_fk_id) '주문한 상품' from orders_number_generator ong
    inner join orders_product op
        on op.orders_number_generator_fk_id = ong.id;