-- schema.sql

-- 1. Major Table
CREATE TABLE Major (
    major_code     VARCHAR(10) PRIMARY KEY,
    major_name     VARCHAR(100) NOT NULL,
    department     VARCHAR(100)
);

-- 2. Professor Table
CREATE TABLE Professor (
    professor_id   INT PRIMARY KEY AUTO_INCREMENT,
    name           VARCHAR(100) NOT NULL,
    email          VARCHAR(100) UNIQUE NOT NULL,
    department     VARCHAR(100)
);

-- 3. Student Table
CREATE TABLE Student (
    student_id        INT PRIMARY KEY AUTO_INCREMENT,
    name              VARCHAR(100) NOT NULL,
    email             VARCHAR(100) UNIQUE NOT NULL,
    major             VARCHAR(10),
    academic_standing VARCHAR(50),
    FOREIGN KEY (major) REFERENCES Major(major_code)
);

-- 4. Course Table
CREATE TABLE Course (
    course_id      INT PRIMARY KEY AUTO_INCREMENT,
    title          VARCHAR(100) NOT NULL,
    credits        INT NOT NULL,
    major          VARCHAR(10),
    professor_id   INT,
    FOREIGN KEY (major) REFERENCES Major(major_code),
    FOREIGN KEY (professor_id) REFERENCES Professor(professor_id)
);

-- 5. Schedule Table
CREATE TABLE Schedule (
    schedule_id    INT PRIMARY KEY AUTO_INCREMENT,
    course_id      INT NOT NULL,
    semester       VARCHAR(20) NOT NULL,
    day            VARCHAR(15) NOT NULL,
    time           VARCHAR(20) NOT NULL,
    room           VARCHAR(30),
    FOREIGN KEY (course_id) REFERENCES Course(course_id)
);

-- 6. Enrollment Table
CREATE TABLE Enrollment (
    enrollment_id      INT PRIMARY KEY AUTO_INCREMENT,
    student_id         INT NOT NULL,
    course_id          INT NOT NULL,
    status             VARCHAR(20),
    waitlist_position  INT,
    FOREIGN KEY (student_id) REFERENCES Student(student_id),
    FOREIGN KEY (course_id) REFERENCES Course(course_id)
);
