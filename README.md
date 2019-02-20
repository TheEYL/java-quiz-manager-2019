# java-quiz-manager-2019

## Setup Eclipse
In your "run configurations" > "arguments" set "VM arguments to"

        -Dconf.location=app.properties
        
## Database connection
To enable multiple user connections on the database 'test.db' we use

        jdbc.url=jdbc:h2:tcp://localhost/./testdb;FILE_LOCK=NO
        

## User guide. 

The program allows you to take a test or to create, read, update and delete questions.

### Take a test.
1.  Enter unique name. The program uses this name to fetch the quiz results to it's important to remember that names can be used only once.
2.  Select a Topic. The program displays a list of all the topics in the database and allows the user to select the topics that he/she want. Topics are separated by commas.
3.  Select max difficulty. User selects the maximum difficulty of questions he wants to take and the program will return questions matching that threshold.
4.  User takes the test. Inserts numbers corresponding to the choice made.
5.  When the test is over, user is asked if he want to exit the app or if he want to take another test.

### Create MCQ questions
1. Login as admin with default credentials. username:admin, password:admin.
2. Select action to undertake:

        2.1 Create question
                2.1.1 choose question type.
        2.2 Read questions. Displays all questions id

        2.3 Update questions. give Id and new question. (Can only update in this manner of now)

        2.4 Delete questions. give Id and question will be deleted. 
