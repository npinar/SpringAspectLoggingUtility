logging implemented using Spring AOP and AspectJ. 

This logging application logs method entries and exits. You can use this application to trouble
shoot issues in pre-production environments.


I used @Aspect approach to implement the logging aspect. The 
logging aspect logs the method name, argument values, return value and any 
exception that is thrown. 
