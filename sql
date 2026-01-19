CREATE EXTENSION IF NOT EXISTS vector;
CREATE TABLE persons (
  id SERIAL PRIMARY KEY,
  name TEXT,
  embedding vector(128)
);
-- index
CREATE INDEX ix_persons_embedding ON persons USING ivfflat (embedding vector_l2_ops) WITH (lists = 100);
