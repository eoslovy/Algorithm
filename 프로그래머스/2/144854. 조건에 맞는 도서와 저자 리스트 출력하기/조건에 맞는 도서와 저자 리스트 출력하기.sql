select a.book_id, b.author_name, date_format(a.published_date,'%Y-%m-%d') published_date
from book a left join author b
on a.author_id = b.author_id
where category = '경제'
order by a.published_date 
