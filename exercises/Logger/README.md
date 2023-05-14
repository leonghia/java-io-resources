# Logger

Create a class named ``Logger`` with a static method *write()*, which will append a certain text to a file. For example:

````java
Logger.write("myLog.txt", "This text is being logged");
````

It must also include the current date and time before the text (in the same line), so that the log file is easier to analyze.

**Hint:** Use ``LocalDateTime`` to get the current date and time.