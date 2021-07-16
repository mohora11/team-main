USE team;

CREATE TABLE tbl_member (
	userid VARCHAR(50) PRIMARY KEY,
    userpw VARCHAR(100) NOT NULL,
    username VARCHAR(100) NOT NULL,
    regdate TIMESTAMP DEFAULT NOW(),
    updateDate TIMESTAMP DEFAULT NOW(),
    enabled TINYINT(1) DEFAULT 1
);

DROP TABLE tbl_member1;
DROP TABLE tbl_member_auth;
SELECT * FROM tbl_member;

CREATE TABLE tbl_member_auth (
	id INT PRIMARY KEY AUTO_INCREMENT,
	userid VARCHAR(50) NOT NULL,
    auth VARCHAR(50) NOT NULL,
    FOREIGN KEY (userid) REFERENCES tbl_member(userid)
);

SELECT * FROM tbl_member;
SELECT * FROM tbl_member_auth;

DELETE FROM tbl_member WHERE tbl_member ;

SELECT * FROM tbl_member1;

  SELECT 
	m.userid userid,
	m.userpw userpw,
	m.username username,
	m.enabled enabled,
	m.regdate regdate,
	m.updateDate updateDate,
	a.auth auth
  FROM 
    tbl_member m LEFT JOIN tbl_member_auth a ON m.userid = a.userid
  WHERE
    m.userid = 'admin';
    
CREATE TABLE tbl_member1(
  memberId VARCHAR(50),
  memberPw VARCHAR(100) NOT NULL,
  memberName VARCHAR(30) NOT NULL,
  memberNickName VARCHAR(30) NOT NULL,
  memberMail VARCHAR(100) NOT NULL,
  memberAddr1 VARCHAR(100) NOT NULL,
  memberAddr2 VARCHAR(100) NOT NULL,
  memberAddr3 VARCHAR(100) NOT NULL,
  adminCk int NOT NULL,
  regDate DATE NOT NULL,
  money int NOT NULL,
  PRIMARY KEY(memberId)
);

insert into tbl_member1 values('admin', 'admin', 'admin', 'admin', 'admin', 'admin', 'admin', 1, sysdate(), 1000000, 1000000);

insert into tbl_member values('admin', 'admin', 'admin', 'admin', 'admin', 'admin', 'admin', 1, sysdate(), 1000000, 1000000);

insert into tbl_member values('admin', 'admin','admin');

INSERT INTO tbl_member VALUES ('member','member','member');


  	INSERT INTO tbl_member
  	(userid, userpw, username)
  	VALUES 
  	('test','test','test')
    
  	INSERT INTO tbl_member_auth VALUES('admin','admin','ROLE_ADMIN');
    
    INSERT INTO tbl_member_auth
  	(userid, auth)
  	VALUES
  	('test', 'ROLE_MEMBER');
  	
   





