-- 코드를 작성해주세요
select e.id, count(d.parent_id) child_count
from ecoli_data e left join ecoli_data d
on e.id = d.parent_id 
group by e.id
order by id