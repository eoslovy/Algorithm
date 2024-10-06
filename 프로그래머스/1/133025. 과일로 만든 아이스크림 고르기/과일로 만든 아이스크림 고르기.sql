-- 코드를 입력하세요
SELECT f.FLAVOR
from first_half f left join icecream_info i on i.flavor=f.flavor
where f.total_order>3000 and i.ingredient_type = "fruit_based"