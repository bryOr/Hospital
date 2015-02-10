CREATE TABLE IF NOT EXISTS Hospital (
	hospitalID INT PRIMARY KEY
	,name VARCHAR(50)
	,address VARCHAR(150)
	,phone VARCHAR(50)
	,numberOfBeds INT
)

CREATE TABLE IF NOT EXISTS HospitalRoom (
	roomID INT
	,hospitalID INT
	,name VARCHAR(50)
	,numberOfBeds INT
	,PRIMARY KEY ( roomID, hospitalID )
	,FOREIGN KEY ( hospitalID ) REFERENCES Hospital ( hospitalID )
)

CREATE TABLE IF NOT EXISTS Doctor (
	doctorID INT PRIMARY KEY
	,ci VARCHAR(20)
	,name VARCHAR(50)
	,specialty VARCHAR(50)
	,hospitalID INT
	,FOREIGN KEY ( hospitalID ) REFERENCES Hospital ( hospitalID )
)

CREATE TABLE IF NOT EXISTS Lab (
	labID INT PRIMARY KEY
	,name VARCHAR(50)
	,address VARCHAR(50)
	,phone VARCHAR(25)
)

CREATE TABLE IF NOT EXISTS LabTest (
	labTestID INT PRIMARY KEY
	,labID INT
	,hospitalID INT
	,serviceDescription TEXT
	,testDate DATE
	,FOREIGN KEY ( labID ) REFERENCES Lab ( labID )
	,FOREIGN KEY ( hospitalID ) REFERENCES Hospital ( hospitalID )
)

CREATE TABLE IF NOT EXISTS Patient (
	patientID INT PRIMARY KEY
	,ci VARCHAR(20)
	,registrationNumber VARCHAR(30)
	,name VARCHAR(50)
	,bedNumber INT
	,address VARCHAR(150)
	,dateOfBirth DATE
	,sex CHAR(1)
	,roomID INT
	,FOREIGN KEY ( roomID ) REFERENCES HospitalRoom ( roomID )
)

CREATE TABLE IF NOT EXISTS DoctorVisit (
	doctorVisitID INT PRIMARY KEY
	,doctorID INT
	,patientID INT
	,visitDate DATE
	,FOREIGN KEY ( doctorID ) REFERENCES Doctor ( doctorID )
	,FOREIGN KEY ( patientID ) REFERENCES Patient ( patientID )
)

CREATE TABLE IF NOT EXISTS Diagnosis (
	diagnosisID INT PRIMARY KEY
	,diagnosisType VARCHAR(100)
	,complications TEXT
	,diagnosisDate DATE
	,patientID INT
	,FOREIGN KEY ( patientID ) REFERENCES Patient ( patientID )
)
