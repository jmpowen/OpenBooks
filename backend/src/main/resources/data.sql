use hack;

SET FOREIGN_KEY_CHECKS = 0;                     /* Turns off checks for Foreign keys which helps for dropping tables easier*/
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS donor;
DROP TABLE IF EXISTS charity_volunteer;
DROP TABLE IF EXISTS charity;
DROP TABLE IF EXISTS donation;
DROP TABLE IF EXISTS expense;
DROP TABLE IF EXISTS images;

SET FOREIGN_KEY_CHECKS = 1;                     /* Turns on checks for foreign keys, which needs to be on to add all these*/
CREATE TABLE user (
  user_id INT(11) NOT NULL AUTO_INCREMENT,
  user_email VARCHAR(128),
  username VARCHAR(128),
  user_biography VARCHAR(1200),

  PRIMARY KEY (user_id)
);

ALTER TABLE user AUTO_INCREMENT=0;

/* Full User Insert */
INSERT INTO user(user_email, username, user_biography) VALUES
	('TomDodge@gmail.com', 'TomDodge', 'Tom Dodge, Tom Dodge, Tom Dodge'),
	('wasartin@iastate.edu', 'barefoot bill', '6 foot 4.75 inches'),
	('BigBird@sesameStreet.com', 'Bird', 'Big Bird is a character on the children\'s television show Sesame Street. Officially performed by Caroll Spinney from 1969 to 2018, he is an eight-foot two-inch tall bright yellow anthropomorphic canary. He can roller skate, ice skate, dance, swim, sing, write poetry, draw, and even ride a unicycle'),
	('hughMan@planetexpress.com', 'Person', 'Hoo-Man? Now\'s thats a name you can trust'),
	('longjohnSilver@plentyOfFish.com', 'Captain', 'Arrrrgh'),
	('milkShakeSuma@dangerCart.com', 'Master Shake', 'Shake zula, the mic rula, the old schoola, you want a trip, I’ll bring it to ya'),
	('vincentAdultman@corporatePlace.com', 'Vincent Man', 'I went to stock market today. I did a business.'),
	('gilbertPatel@Uruk.com', 'Gil', 'King of Uruk'),
	('cowman@Springs.com', 'Cat', 'Insert Bio'),
    ('graysoncox98@gmail.com', 'Raisin Box', 'asdf');

CREATE TABLE donor (
	donor_id INT(11),

    FOREIGN KEY(donor_id) REFERENCES user(user_id) ON DELETE CASCADE
);

CREATE TABLE charity(
	charity_id INT(11) NOT NULL AUTO_INCREMENT,	/* Unique Id for each Charity Organization */
	charity_name VARCHAR(128),  				/* After less than two minutes of googling, 46 chars was the longest I could find */
    charity_nickname VARCHAR(66),
    charity_description VARCHAR(1200), 			/* This is obtained by the average paragraph length (200 words) * the average word length (6 characters) */
    charity_trending_rank INT(11),
    charity_category VARCHAR(128),
    charity_links LONGTEXT,						/* LONGTEXT is an alias for JSON, this is used for compatibility issues.*/
    charity_balance DECIMAL(19,4), 				/* This datatype is recommended by the first stackoverflow via google ''best datatype money SQL'' */
	PRIMARY KEY(charity_id)
);
ALTER TABLE charity AUTO_INCREMENT=0;

CREATE TABLE charity_volunteer (
	volunteer_id INT(11),
	charity_id INT(11),
    title VARCHAR(128),
    salary DECIMAL(19, 4),

	PRIMARY KEY(volunteer_id),
    FOREIGN KEY (volunteer_id) REFERENCES user(user_id) ON DELETE CASCADE,
    FOREIGN KEY(charity_id) REFERENCES charity(charity_id) ON DELETE CASCADE
);


INSERT INTO charity( charity_name, charity_nickname, charity_description, charity_trending_rank) VALUES
	('Ronald McDonalds House', 'Micky D\'s Place', 'Ronald McDonald House Charities is an American independent nonprofit organization whose stated mission is to create, find, and support programs that directly improve the health and well-being of children.', 0),
	('SeBass\'s Bar & Grill', 'SBG', 'Come on down to the best seafood experience this side of the Delaware', 0),
	('Susan G Kommen Breast Cancer Foundation', 'Susan B', 'Susan G. Komen, formerly known as Susan G. Komen for the Cure and originally as The Susan G. Komen Breast Cancer Foundation, often referred to as simply Komen, is the largest and best-funded breast cancer organization in the United States. - Save the Ta-Ta\'s', 0),
    ('Charitable Table', 'C-T', 'Making Tables more Stables', 0),
    ('Jerry\'s Kids', '', 'Help give Jerry\'s kids some Cable T.V. this holiday winter.', 0);

    /* TODO: see relationship with expense table */
CREATE TABLE donation (
	donation_id INT(11) NOT NULL AUTO_INCREMENT,
    donation_amount DECIMAL(19, 4),
    donation_comment VARCHAR(256),
    charity_id INT(11),
    donor_id INT(11),

	PRIMARY KEY (donation_id),
    FOREIGN KEY(donor_id) REFERENCES donor(donor_id),
    FOREIGN KEY(charity_id) REFERENCES charity(charity_id)
);

ALTER TABLE donation AUTO_INCREMENT=0;

    /* ToDo: FOREIGN KEY(expense_account_id) */
CREATE TABLE expense (
	expense_id INT(11) NOT NULL AUTO_INCREMENT,
	charity_id INT(11),
    expense_title VARCHAR(120),
    expense_description VARCHAR(1200),
    expense_amount DECIMAL(19, 4),
    expense_date DATE,
    PRIMARY KEY(expense_id),
    FOREIGN KEY(charity_id) REFERENCES charity(charity_id)
);

ALTER TABLE expense AUTO_INCREMENT=0;


CREATE TABLE images (
    image_id INT(11) NOT NULL AUTO_INCREMENT,
    charity_id INT(11),
    image blob,
    image_description VARCHAR(1200),
    image_category VARCHAR(128),
    PRIMARY KEY(image_id),
    FOREIGN KEY(charity_id) REFERENCES charity(charity_id)
)