CREATE TABLE toggles (
    id SERIAL PRIMARY KEY
    ,name VARCHAR(255) NOT NULL UNIQUE
    ,decision CHAR(3) NOT NULL
)