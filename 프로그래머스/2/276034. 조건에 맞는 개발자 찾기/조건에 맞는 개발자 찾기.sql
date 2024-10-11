-- 코드를 작성해주세요
select distinct(id), email, first_name, last_name
from developers d left join skillcodes s
on d.skill_code & s.code
where s.name = "Python" or s.name = "C#"
order by id