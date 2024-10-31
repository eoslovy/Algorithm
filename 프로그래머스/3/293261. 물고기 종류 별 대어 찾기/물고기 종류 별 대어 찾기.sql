SELECT a.id, b.fish_name, a.length
FROM fish_info a
JOIN fish_name_info b ON a.fish_type = b.fish_type
WHERE (a.fish_type, a.length) IN (
    SELECT fish_type, MAX(length)
    FROM fish_info
    GROUP BY fish_type
)
ORDER BY a.id;