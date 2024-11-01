SELECT flavor
FROM (
    SELECT flavor, 
           SUM(total_order) AS total_order_sum
    FROM (
        SELECT flavor, total_order
        FROM first_half
        UNION ALL
        SELECT flavor, total_order
        FROM july
    ) AS combined
    GROUP BY flavor
) AS flavor_totals
ORDER BY total_order_sum DESC
LIMIT 3;
