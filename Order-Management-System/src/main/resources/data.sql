INSERT INTO `fis-final`.`tbl_customer` (`id`, `address`, `mobile`, `name`) VALUES ('1', 'Ha Noi', '09898989', 'Phong');
INSERT INTO `fis-final`.`tbl_customer` (`id`, `address`, `mobile`, `name`) VALUES ('2', 'Vinh Phuc', '098987', 'Thanh');
INSERT INTO `fis-final`.`tbl_customer` (`id`, `address`, `mobile`, `name`) VALUES ('3', 'Ha Noi', '0789846', 'Dat');
INSERT INTO `fis-final`.`tbl_customer` (`id`, `address`, `mobile`, `name`) VALUES ('4', 'Ha Nam', '09565678', 'Manh');


INSERT INTO `fis-final`.`tbl_order` (`id`, `order_datetime`, `status`, `total_amount`, `customer_id`) VALUES ('1', '2022-07-18 00:04:00', 'CREATED', '0', '1');
INSERT INTO `fis-final`.`tbl_order` (`id`, `order_datetime`, `status`, `total_amount`, `customer_id`) VALUES ('2', '2020-07-18 00:04:00', 'PAID', '0', '2');


INSERT INTO `fis-final`.`tbl_product` (`id`, `avaiable`, `name`, `price`) VALUES ('1', '10', 'Thit', '12000');
INSERT INTO `fis-final`.`tbl_product` (`id`, `avaiable`, `name`, `price`) VALUES ('2', '20', 'Rau', '5000');
INSERT INTO `fis-final`.`tbl_product` (`id`, `avaiable`, `name`, `price`) VALUES ('3', '15', 'Ca', '50000');
INSERT INTO `fis-final`.`tbl_product` (`id`, `avaiable`, `name`, `price`) VALUES ('4', '20', 'Banh', '35000');

INSERT INTO `fis-final`.`tbl_order_item` (`id`, `amount`, `quantity`, `order_id`, `product_id`) VALUES ('1', '0', '3', '1', '1');
INSERT INTO `fis-final`.`tbl_order_item` (`id`, `amount`, `quantity`, `order_id`, `product_id`) VALUES ('2', '0', '2', '1', '2');
INSERT INTO `fis-final`.`tbl_order_item` (`id`, `amount`, `quantity`, `order_id`, `product_id`) VALUES ('3', '0', '1', '2', '1');
