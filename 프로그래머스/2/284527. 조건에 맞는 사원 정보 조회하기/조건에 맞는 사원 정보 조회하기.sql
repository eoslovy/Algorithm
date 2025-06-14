WITH TMP AS(
    SELECT EMP_NO, SUM(SCORE) AS SCORE
    FROM HR_GRADE
    GROUP BY EMP_NO
    ORDER BY SUM(SCORE) DESC
    LIMIT 1
)

SELECT TMP.SCORE, B.EMP_NO, B.EMP_NAME, B.POSITION, B.EMAIL
FROM TMP
JOIN HR_EMPLOYEES B ON TMP.EMP_NO = B.EMP_NO
JOIN HR_DEPARTMENT A ON A.DEPT_ID = B.DEPT_ID;