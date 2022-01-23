-- 交易 Demo 所需的資料表

CREATE TABLE if not exists book (
    bid INTEGER NOT NULL auto_increment, -- 主鍵序號
    bname varchar(20) not null, -- 書名
    price INTEGER, -- 價格 
    ct timestamp default current_timestamp, -- 建檔時間
    PRIMARY KEY (bid)
);

CREATE TABLE if not exists stock (
    sid INTEGER NOT NULL auto_increment, -- 主鍵序號
    bid INTEGER NOT NULL,
    amount INTEGER, -- 數量 
    PRIMARY KEY (sid)
);

CREATE TABLE if not exists wallet (
    wid INTEGER NOT NULL auto_increment, -- 主鍵序號
    money INTEGER, -- 數量 
    wname varchar(50),
    PRIMARY KEY (wid)
);
-- homework 建立交易紀錄 order_log
-- vic buy java 2 300
Insert into wallet(money) values(100);
Insert into book(bname, price) values('Java', 80);
Insert into stock(bid, amount) values(1, 3);

