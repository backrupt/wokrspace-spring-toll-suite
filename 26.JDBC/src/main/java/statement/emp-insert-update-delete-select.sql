--emp crud
--select
select * from emp;
select empno,ename,job,sal,hiredate  from emp where sal >=1000 and sal <= 4000 and job = 'SALSMAN' or job = 'CLERK';

--insert
insert into emp values(9000,'JUNG','MANAGER',7369,to_date('2000/01/10','YYYY/MM/DD'),3000.34,30,40);
--update
update emp set sal = sal*1.3 where empno>=7369 and empno<=7600;
--delete
delete from emp where empno=9000;

commit