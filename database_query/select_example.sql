# cart와 cart_product 조인하기
# 카트 ID, 회원정보, 제품명, 수량 조회
select
    c.id as '카트ID',
    (select name from member where member.id = c.member_fk_id) as '회원이름',
    (select name from product where product.id = cp.product_fk_id) as '제품명',
    cp.product_cnt as '제품수량'
    from cart c inner join cart_product cp
on c.id = cp.cart_fk_id;