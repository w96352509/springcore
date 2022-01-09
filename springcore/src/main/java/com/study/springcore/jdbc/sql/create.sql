-- 建立員工資料表
create table emp if not exists emp(
  eid int not null auto_increment, --主鍵(自動產生序號1~過號不返回)
  ename varchar(50) not null unique, --員工姓名不可相同
  age int, -- 員工年齡
  create timestamp default current_timestamp, -- 建檔時間
  primary key(eid)
)