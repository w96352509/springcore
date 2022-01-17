-- 1 --
select i3.id ,i2.pname from  item i , itemproduct i2 ,invoice i3 
where i.ipid = i2.id and i.invid =i3.id 
-- 2 --
select i2.invid ,count(i.pname)  ,i.price, i.inventory 
from itemproduct i ,item i2  
where i2.ipid  = i.id 
GROUP by i2.invid 
-- 3 --
select i3.id as '發票id' ,sum((i.price * i2.amount)) as '價錢'  
from itemproduct i ,item i2 ,invoice i3 
where i2.ipid  = i.id  and i2.invid = i3.id 
group by i3.id 
-- 4 --
select  i.pname , i.price from itemproduct i 
-- 5 --
select i2.pname ,  sum(i.amount ) as '最大值' from item i  ,itemproduct i2
where i.ipid =i2.id 
group by i2.pname  
order by i.amount limit 1
-- 6 --
select i2.pname ,  max(i2.price)  as '最大值' from item i  ,itemproduct i2
where i.ipid =i2.id 
group by i2.pname  
order by i.amount limit 1
      
