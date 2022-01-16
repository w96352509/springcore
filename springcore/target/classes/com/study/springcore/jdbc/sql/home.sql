-- 1 --
select  id,pname,price,inventory 
from itemproduct i 
where id = ? 
-- 2 --
select i2.invid ,count(i.pname)  ,i.price, i.inventory 
from itemproduct i ,item i2  
where i2.ipid  = i.id 
GROUP by i2.invid 
      
