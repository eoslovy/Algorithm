select e.id, e.genotype, d.genotype as parent_genotype
from ecoli_data e left join ecoli_data d
on e.parent_id = d.id
where e.genotype & d.genotype = cast(d.genotype as binary)
order by e.id