-- 코드를 작성해주세요
SELECT
    A.ID
    , A.GENOTYPE
    , P.GENOTYPE AS PARENT_GENOTYPE
FROM ECOLI_DATA AS A, ECOLI_DATA AS P
WHERE A.PARENT_ID = P.ID AND A.GENOTYPE & P.GENOTYPE = P.GENOTYPE

ORDER BY ID;