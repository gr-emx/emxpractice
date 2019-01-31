<H1>Project for EMX application</H1>
This application uses spring boot to respond to the form given by EMX. 
<h1>Before We Begin</h1>
Out of all the questions that are asked, a final one is a "Puzzle"
that we are required to solve. Instead of wasting time trying to 
logically solve the puzzle, I used a semi machine learning based approach of
solving such a puzzle. 

This is done in 3 steps. 
1) We first train the model. In that, requests are fired programmatically
to this endpoint to see what the server expects
2) The expected response is noted and sent back as feedback.  
This feedback is saved in the "trainingdata.txt" file
3) Finally, when we are ready to test it, the response refers to 
this trainingdata.txt file and responds to every subsequent request. 

I have trained with around 50 different datapoints. But for a 
higher accuracy, we can continue training this model. 


<h1>Setup</h1>
<h2>Setup config</h2>
The most important file to setup is <strong>/src/main/resources/application.properties</strong>
This file has all the data that is necessary. to begin but 
be sure to modify it for accuracy. 
properties to be set - 
<ul>
<li>request.body=url=http%3A%2F%2Ff91f77f3.ngrok.io%2Frespond The url of this service. This will help train the algorithm</li>
<li>emx.url=http://resumes.brealtime.com/test.php The submission page uses a php script to call this url. This is required to train the dataset</li>
<li>training.filename=trainingdata.txt The file to save the training dataset for the puzzle</li>

</ul>
<h1>Tests</h1>
This application follows a strict test driven approach. The tests are in the 
src/test/java folder. mvn clean package will also run all tests. 
<h1> Run </h1>
mvn spring-boot:run or you can package the application and run as 
mvn clean package and then run java -jar target/myapplication-0.0.1-SNAPSHOT.jar