# ShipService
Code test for Williams Sonoma

This is a Maven Eclipse project including Juin test and custome CheckStyle. Download and add this project into your eclipse, then you can run all Junit test classes one by one. TestMain is the main test class. Run it as Junit Test, then it would print some information on console, which invites you to type in a set of ZipRange objects in certain formate. If your input breaks the formate rules, then it would show error message, and let you try agaim. If and only if your inputs satisfy the formate requirements, then it would process the data, and print the final result on console.

To check whether the code style follows google code standards, open command line and cd into the project folder, and then rum mvn checkstyle:checkstyle. This step would use google_checks.xml existing main/resource folder to generate checks-result.xml inside target folder. The another way is to activate CheckStyle in Eclipse. Any line of code which violates google coding standards would be shown in Eclipse.

Maven build will run JUnit test and checkstyle. The TestMain.java is excluded from maven test phase since this class can be run only as Junit test with tester's input.
