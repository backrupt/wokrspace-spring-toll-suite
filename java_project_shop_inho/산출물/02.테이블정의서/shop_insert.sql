/**************member insert******************/
INSERT INTO userInfo (userId, password, name, email) VALUES ('dlsgh1', 112344, '최인호1', 'dlsgh1@naver.com');
INSERT INTO userInfo (userId, password, name, email) VALUES ('dlsgh2', 112344, '최인호2', 'dlsgh2@naver.com');
INSERT INTO userInfo (userId, password, name, email) VALUES ('dlsgh3', 112344, '최인호3', 'dlsgh3@naver.com');
INSERT INTO userInfo (userId, password, name, email) VALUES ('dlsgh4', 112344, '최인호4', 'dlsgh4@naver.com');

/**************product insert******************/
insert into product values(1, '비글', 550000, 'bigle.png','기타 상세 정보 등...', 0);
insert into product values(2, '달마시안', 500000, 'dalma.jpg','기타 상세 정보 등...', 0);
insert into product values(3, '퍼그', 400000, 'pug.jpg','기타 상세 정보 등...', 0);
insert into product values(4, '페키니즈', 450000, 'pekiniz.png','기타 상세 정보 등...', 0);
insert into product values(5, '포메라니안', 800000, 'pomeranian.jpg','기타 상세 정보 등...', 0);
insert into product values(6, '샤페이', 700000, 'shaipei.jpg','기타 상세 정보 등...', 0);
insert into product values(7, '닥스훈트', 800000, 'dachshund.jpg','기타 상세 정보 등...', 0);
insert into product values(8, '사모예드', 800000, 'samoyed.jpg','기타 상세 정보 등...', 0);

/**************cart insert******************/
--dlsgh1님이 1번 2개, 3번 1개, 7번 3개 
insert into cart (cart_no,userId,p_no,cart_qty) values (cart_cart_no_seq.nextval,'dlsgh1',1,2);
insert into cart (cart_no,userId,p_no,cart_qty) values (cart_cart_no_seq.nextval,'dlsgh1',3,1);
insert into cart (cart_no,userId,p_no,cart_qty) values (cart_cart_no_seq.nextval,'dlsgh1',7,3);

--dlsgh2님이 1번 2개, 3번 1개, 7번 3개 
insert into cart (cart_no,userId,p_no,cart_qty) values (cart_cart_no_seq.nextval,'dlsgh2',1,2);
insert into cart (cart_no,userId,p_no,cart_qty) values (cart_cart_no_seq.nextval,'dlsgh2',3,1);
insert into cart (cart_no,userId,p_no,cart_qty) values (cart_cart_no_seq.nextval,'dlsgh2',7,3);
