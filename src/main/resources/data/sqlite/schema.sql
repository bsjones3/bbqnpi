CREATE DATABASE IF NOT EXISTS 'templog';
USE 'templog';
DROP TABLE temps;
CREATE TABLE temps(timestamp time default (strftime('%s', 'now')), sensnum numeric, temp numeric);