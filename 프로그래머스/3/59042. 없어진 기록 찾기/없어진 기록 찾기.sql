SELECT A.ANIMAL_ID, A.NAME
FROM ANIMAL_OUTS A
WHERE A.ANIMAL_ID NOT IN(SELECT ANIMAL_ID FROM ANIMAL_INS)
ORDER BY A.ANIMAL_ID, A.NAME