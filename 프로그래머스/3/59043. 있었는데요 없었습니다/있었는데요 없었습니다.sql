select a.animal_id, a.name
from animal_ins a inner join (
    select animal_id, datetime tmp
    from animal_outs) b
on a.animal_id = b.animal_id
where a.datetime > b.tmp
order by a.datetime