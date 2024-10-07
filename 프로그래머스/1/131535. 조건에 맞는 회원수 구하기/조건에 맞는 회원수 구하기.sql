-- 코드를 입력하세요
SELECT count(user_id) users
from user_info
where date_format(joined, "%Y") = "2021" and 20<=age and age<=29