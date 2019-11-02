

CREATE TABLE user (
  user_id int(11) NOT NULL AUTO_INCREMENT,
  user_email varchar(128),
  username varchar(128),
  biography varchar(1200),
  
  PRIMARY KEY (user_id)
);

CREATE TABLE donor (
	donor_id int(11),
    
    FOREIGN KEY(donor_id) REFERENCES user(user_id)
);

-- TODO: See relationship with charity table
CREATE TABLE charity_volunteer (
	volunteer_id int(11),
    
	FOREIGN KEY(volunteer_id) REFERENCES user(user_id)
);

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

CREATE TABLE volunteers (
	charity_id int(11),
    volunteer_id int(11),
    position varchar(128),
    salary decimal(19, 4),
    
    PRIMARY KEY(charity_id, volunteer_id),
    FOREIGN KEY(charity_id) REFERENCES charity(charity_id),
    FOREIGN KEY(volunteer_id) REFERENCES charity_volunteer(volunteer_id)

);