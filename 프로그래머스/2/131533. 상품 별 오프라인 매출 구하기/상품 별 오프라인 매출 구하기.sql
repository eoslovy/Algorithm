select b.product_code, sum(a.sales_amount) * b.price as sales
from offline_sale a left join product b 
on a.product_id = b.product_id
group by a.product_id
order by sales desc, b.product_code