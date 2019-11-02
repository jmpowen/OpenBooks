use hack;

SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS donor;
DROP TABLE IF EXISTS charity_volunteer;

DROP TABLE IF EXISTS charity;
DROP TABLE IF EXISTS donation;
DROP TABLE IF EXISTS volunteers;
DROP TABLE IF EXISTS expense;

SET FOREIGN_KEY_CHECKS = 1;
CREATE TABLE user (
  user_id int(11) NOT NULL AUTO_INCREMENT,
  user_email varchar(128),
  username varchar(128),
  biography varchar(1200),

  PRIMARY KEY (user_id)
);

ALTER TABLE user AUTO_INCREMENT=0;

CREATE TABLE donor (
	donor_id int(11),

    FOREIGN KEY(donor_id) REFERENCES user(user_id) ON DELETE CASCADE
);

-- TODO: See relationship with charity table
CREATE TABLE charity_volunteer (
	volunteer_id int(11),

	FOREIGN KEY(volunteer_id) REFERENCES user(user_id) ON DELETE CASCADE
);

CREATE TABLE charity(
	charity_id INT(11) NOT NULL AUTO_INCREMENT,	/* Unique Id for each Charity Organization */
	charity_name VARCHAR(128),  				/* After less than two minutes of googling, 46 chars was the longest I could find */
    charity_nick_name VARCHAR(66),
    charity_description VARCHAR(1200), 			/* This is obtained by the average paragraph length (200 words) * the average word length (6 characters) */
    charity_trending_rank INT(11),
    /* ToDo: charity_links JSON ? */
    charity_balance DECIMAL(19,4), 				/* This datatype is recommended by the first stackoverflow via google 'best datatype money SQL' */
	PRIMARY KEY(charity_id)
);

ALTER TABLE charity AUTO_INCREMENT=0;

-- TODO: see relationship with expense table
CREATE TABLE donation (
	donation_id int(11) NOT NULL AUTO_INCREMENT,
    amount decimal(19, 4),
    comment varchar(256),
    charity_id int(11),
    donor_id int(11),

	PRIMARY KEY (donation_id),
    FOREIGN KEY(donor_id) REFERENCES donor(donor_id),
    FOREIGN KEY(charity_id) REFERENCES charity(charity_id)
);

ALTER TABLE donation AUTO_INCREMENT=0;

CREATE TABLE volunteers (
	charity_id int(11),
    volunteer_id int(11),
    position varchar(128),
    salary decimal(19, 4),
    
    PRIMARY KEY(charity_id, volunteer_id),
    FOREIGN KEY(charity_id) REFERENCES charity(charity_id) ON DELETE CASCADE,
    FOREIGN KEY(volunteer_id) REFERENCES charity_volunteer(volunteer_id) ON DELETE CASCADE
);

CREATE TABLE expense (
	expense_id INT(11) NOT NULL AUTO_INCREMENT,
	charity_id INT(11),
    expense_title VARCHAR(120),
    expense_description VARCHAR(1200),
    expense_amount DECIMAL(19, 4),
    expense_date DATE,
    expense_account_id INT(11),
    PRIMARY KEY(expense_id),
    FOREIGN KEY(charity_id) REFERENCES charity(charity_id)
    /* ToDo: FOREIGN KEY(expense_account_id) */
);

ALTER TABLE expense AUTO_INCREMENT=0;