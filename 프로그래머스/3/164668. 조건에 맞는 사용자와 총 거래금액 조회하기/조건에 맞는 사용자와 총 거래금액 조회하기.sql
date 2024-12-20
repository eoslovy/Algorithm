SELECT A.USER_ID, A.NICKNAME, B.TOTAL AS TOTAL_SALES
FROM USED_GOODS_USER A
JOIN
(
    SELECT WRITER_ID, SUM(PRICE) AS TOTAL
    FROM USED_GOODS_BOARD
    WHERE STATUS = 'DONE'
    GROUP BY WRITER_ID
    HAVING SUM(PRICE) >= 700000
) B
ON A.USER_ID = B.WRITER_ID
ORDER BY B.TOTAL