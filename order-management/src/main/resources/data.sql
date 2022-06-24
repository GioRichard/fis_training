
insert into tbl_product(name, price) values('Iphone 6s', 1500000);
insert into tbl_product(name, price) values('Iphone 7s', 2000000);
insert into tbl_product(name, price) values('Samsumg A10', 2100000);
insert into tbl_product(name, price) values('Nokia 1200', 30000);

insert into tbl_customer(name, mobile, address) values('Nguyen Van A', '0978 123 456', 'Cau Giay - Ha Noi');
insert into tbl_customer(name, mobile, address) values('Le Van B', '0902 222 333', 'Ha Dong - Ha Noi');


insert into tbl_order(customer_id, total_amount, status, order_datetime) values(1,3500000,'CREATED', now());

insert into tbl_order_item (order_id, product_id, quantity, amount) values(1,1,1,1500000);
insert into tbl_order_item (order_id, product_id, quantity, amount) values(1,2,1,2000000);
