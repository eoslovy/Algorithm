select year(differentiation_date) year, (big-size_of_colony) as year_dev, id
from ecoli_data e1
join
(select year(differentiation_date) as year, max(size_of_colony) as big
 from ecoli_data
 group by year(differentiation_date)
) e2
on year(e1.differentiation_date) = e2.year
order by year, year_dev