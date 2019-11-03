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
  user_email VARCHAR(345) NOT NULL,						/* The current record for longest active email goes to Peter Craig with 345 chars */
  username VARCHAR(128),
  user_biography VARCHAR(1200),

  PRIMARY KEY (user_email)
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
	volunteer_id VARCHAR(345),
	charity_id INT(11),
    title VARCHAR(128),
    salary DECIMAL(19, 4),

	PRIMARY KEY(volunteer_id),
    FOREIGN KEY (volunteer_id) REFERENCES user(user_email) ON DELETE CASCADE,
    FOREIGN KEY(charity_id) REFERENCES charity(charity_id) ON DELETE CASCADE
);

INSERT INTO charity(charity_name, charity_nickname, charity_description, charity_trending_rank) VALUES
	('Ronald McDonalds House', 'Micky D\'s Place', 'Ronald McDonald House Charities is an American independent nonprofit organization whose stated mission is to create, find, and support programs that directly improve the health and well-being of children.', 0),
	('SeBass\'s Bar & Grill', 'SBG', 'Come on down to the best seafood experience this side of the Delaware', 0),
	('Susan G Kommen Breast Cancer Foundation', 'Susan B', 'Susan G. Komen, formerly known as Susan G. Komen for the Cure and originally as The Susan G. Komen Breast Cancer Foundation, often referred to as simply Komen, is the largest and best-funded breast cancer organization in the United States. - Save the Ta-Ta\'s', 0),
    ('Charitable Table', 'C-T', 'Making Tables more Stables', 0),
	('Fishing for old people', 'FFOP', 'hashtagbones', 0),
	('E.D. Support Group', 'EDSG', 'Helping each other up. Rise to this occasion so you can rise to others', 0),
	('American Narcotics Users Support and Rehabilitation Association For Men', 'Today me',  'No Queries here', 0);

    /* TODO: see relationship with expense table */
CREATE TABLE donation (
	donation_id INT(11) NOT NULL AUTO_INCREMENT,
	charity_id INT(11),
    donor_id VARCHAR(345),
    donation_amount DECIMAL(19, 4),
	donation_amount_unused DECIMAL(19,4),
    donation_comment VARCHAR(256),
    donation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

	PRIMARY KEY (donation_id),
    FOREIGN KEY(donor_id) REFERENCES user(user_email),
    FOREIGN KEY(charity_id) REFERENCES charity(charity_id)
);

ALTER TABLE donation AUTO_INCREMENT=0;

INSERT INTO donation(donation_amount, donation_comment, charity_id, donor_id) VALUES
	(0.69, 'Thanks for the great time last night', 3, 'longjohnSilver@plentyOfFish.com'),
	(100.22, 'This is an incredible Charity, thank you so much for what you do', 1, 'wasartin@iastate.edu'),
	(155.80, 'Business-wise, this all seems like appropriate business', 2, 'vincentAdultman@corporatePlace.com'),
	(20.00, 'This is not the Catfishing I thought it would be', 6, 'cowman@Springs.com'),
	(55.99, 'This is the best money laundering services I have found so far', 3, 'TomDodge@gmail.com'),
	(430.00, 'Nothing to see here', 2, 'TomDodge@gmail.com'),
	(123.00, 'This company really does a great job of cleaning my money', 5, 'TomDodge@gmail.com'),
	(0.99, 'Every penny counts', 6, 'graysoncox98@gmail.com'),
	(5000.00, 'Making the world a better place', 2, 'graysoncox98@gmail.com'),
	(5.00, 'Just trying to keep up the good work', 7, 'longJohnSilver@plentyOfFish.com'),
	(1.25, 'Nothing better than donating to something you believe in', 6, 'graysoncox98@gmail.com'),
	(4600.23, 'Scrub, Scrub, Scrub.', 4, 'TomDodge@gmail.com'),
	(333.33, 'SHUCKS', 4, 'gilbertPatel@Uruk.com'),
    (32.22, 'This is the best Charity, whooohoo', 3, 'wasartin@iastate.edu'),
    (155.80, 'I care about humanity', 2, 'hughMan@planetexpress.com'),
	(20.00,  'Hot Dogs for Everybody', 6, 'cowman@Springs.com'),
	(55.99, 'YARRRRgh', 3, 'longjohnSilver@plentyOfFish.com'),
	(430.00, 'Who opened this laundromat', 2, 'TomDodge@gmail.com'),
	(123.00, 'This company really does a great job of cleaning my money', 5, 'gilbertPatel@Uruk.com'),
    (0.99, 'Every penny counts', 7, 'graysoncox98@gmail.com');

    /* ToDo:  KEY(expense_account_id) */
CREATE TABLE expense (
	expense_id INT(11) NOT NULL AUTO_INCREMENT,
	charity_id INT(11),
    expense_title VARCHAR(120),
    expense_description VARCHAR(1200),
    expense_amount DECIMAL(19, 4),
    expense_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(expense_id),
    FOREIGN KEY(charity_id) REFERENCES charity(charity_id)
);

ALTER TABLE expense AUTO_INCREMENT=0;

INSERT INTO expense(charity_id, expense_title, expense_description, expense_amount) VALUES
	(2, 'something', 'description', 55.94),
    (4, 'Legs', 'gotta pay for the legs of the table', 33.90),
    (6, 'Balls', 'I did not even put a header on this, there is no data', 22.93),
    (1, 'John Cena', 'DO DO DO DOOOOh, DO DO DOO DOOO, ', 10.23),
    (3, 'cheese steak', 'They  will know what it means', 50.00),
    (7, 'WHere is my husband', 'it puts lotion on its skin or else it gets what it is told', 24.00),
    (3, 'Hooks & Coke', 'Terrences going away party, Fishingpoolooza', 1000.00),
    (7, 'St. Jude hospital donation', 'Giving hope to terminally ill children, so that they can the joys of life', 0.99),
    (4, 'Tree Season', 'Save the Earth(s) and the Brian (from H.R.) is not invited', 20000000.00),
    (5, 'Tree Chopping Season', 'They are at it again, boys.', 20000001.00),
    (1, 'Skyscrapers', 'A giant skyscraper alright. And its ganna white and its best and ganna be huge', 32000000000.00),
    (1, 'Medium Eggs', 'Can you reach the top shelf for me.', 2.99),
    (6, 'Throat Singing', 'Ödügen Tayga čurttug-la men', 200000.000),
    (4, 'A1A Car Wash', 'Not A Money Laundering Scam', 450.00);

CREATE TABLE images (
    image_id INT(11) NOT NULL AUTO_INCREMENT,
    charity_id INT(11),
    image blob,
    image_description VARCHAR(1200),
    image_category VARCHAR(128),
    PRIMARY KEY(image_id),
    FOREIGN KEY(charity_id) REFERENCES charity(charity_id)
);

SELECT * FROM expense WHERE charity_id = 2;


-- CREATE USER 'pickledprawn'@'%' IDENTIFIED BY 'fickledrawn';

-- GRANT ALL PRIVILEGES ON hack.* TO 'pickledprawn'@'%';
