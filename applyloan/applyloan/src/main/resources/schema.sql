DROP TABLE IF EXISTS loan;
CREATE TABLE IF NOT EXISTS loan (

	loan_id int auto_increment primary key,
	loan_type varchar(50),
	loan_amount varchar(10),
	date varchar(50),
	rate_of_interest varchar(10),
	duration_of_loan varchar(10),
	user_id varchar(10)

);
