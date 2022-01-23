--交易資料表
--book書籍  , stock庫存資料 , wallet客戶錢包
-- 書籍資料
CREATE TABLE if not exists book (
    bid INTEGER NOT NULL auto_increment, -- 主鍵序號
    bname varchar(20) not null, -- 書名
    price INTEGER, -- 價格 
    ct timestamp default current_timestamp, -- 建檔時間
    PRIMARY KEY (bid)
);
-- 庫存資料
create table if not exists stock(
   sid integer not null auto_increment ,
   bid integer not null,
   amount integer,
   primary key(sid),
   foreign key(bid) references book(bid)  -- 外鍵關聯
);

create table if not exists wallet(
	wid integer not null auto_increment,
	wname varchar(50), -- 名稱
	money integer default 0,
	primary key(wid)
);