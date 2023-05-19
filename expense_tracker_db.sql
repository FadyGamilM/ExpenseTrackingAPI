-- we need to drop the database user and the database itself 
-- as we will run this script multiple times
DROP DATABASE IF EXISTS expensetrackerdb;
DROP USER IF EXISTS et_owner;

-- now we need to create the database owner and a password for it
CREATE USER et_owner WITH PASSWORD 'et_password';

-- then create the database itself with an existing postgresql template
CREATE DATABASE expensetrackerdb WITH TEMPLATE=template0 OWNER=et_owner;

-- now connect to the database
\connect expensetrackerdb;

-- modify the privilages for this owner on this database so we can manipulate the tables and sequences on this database
ALTER default privileges grant all on tables to et_owner;
ALTER default privileges grant all on sequences to et_owner;

-- start build the structure of our database
CREATE TABLE IF NOT EXISTS et_users (
    id BIGINT PRIMARY KEY NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    username VARCHAR(100) NOT NULL,
    email VARCHAR(200) UNIQUE NOT NULL,
    password TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS et_categories(
    id BIGINT PRIMARY KEY NOT NULL,
    user_id BIGINT NOT NULL,
    title TEXT NOT NULL,
    description TEXT
    
);

CREATE TABLE IF NOT EXISTS et_transactions (
    id BIGINT PRIMARY KEY NOT NULL,
    amount NUMERIC(10, 2) NOT NULL,
    hint TEXT,
    transaction_date BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    category_id BIGINT NOT NULL
);


-- add fk constraints between tables 
ALTER TABLE et_categories ADD CONSTRAINT cat_user_fk FOREIGN KEY (user_id) REFERENCES et_users(id);
ALTER TABLE et_transactions ADD CONSTRAINT trans_cat_fk FOREIGN KEY (category_id) REFERENCES et_categories(id);
ALTER TABLE et_transactions ADD CONSTRAINT trans_user_fk FOREIGN KEY (user_id) REFERENCES et_users(id);

-- add sequences to manage the PKs
CREATE sequence et_users_seq increment 1 start 1;
CREATE sequence et_categories_seq increment 1 start 1;
CREATE sequence et_transactions_seq increment 1 start 1000;
