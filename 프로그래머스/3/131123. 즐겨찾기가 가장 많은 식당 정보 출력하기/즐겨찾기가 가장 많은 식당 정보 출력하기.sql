SELECT A.FOOD_TYPE, A.REST_ID, A.REST_NAME, A.FAVORITES
FROM REST_INFO A JOIN
(SELECT FOOD_TYPE, MAX(FAVORITES) AS CNT
FROM REST_INFO
GROUP BY FOOD_TYPE
) B
ON A.FOOD_TYPE = B.FOOD_TYPE AND A.FAVORITES = B.CNT
ORDER BY A.FOOD_TYPE DESC

# SELECT FOOD_TYPE, REST_ID, REST_NAME, MAX(FAVORITES) AS FAVORITES
# FROM REST_INFO
# GROUP BY FOOD_TYPE
# ORDER BY FOOD_TYPE DESC

# SELECT *
# FROM REST_INFO