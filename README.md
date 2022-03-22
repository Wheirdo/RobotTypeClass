# RobotTypeClass
Iterations of improving a type function that takes in a string, and types each letter out using Java's robot class


The basic idea is going through each character of a string, figuring out which robot keyCode matches that charcter, then using it to type. 
The first version uses if statements for all characters that aren't letters or numbers
The second version adds all special characters to an array, and reads from it instead of the if statements
The third version uses a csv file
More detailed explanation for each version is in the comments of each file

I'm not completly satiated with V3 - I think a Hash Map might work, but I don't yet know enough about them to implement it properly

delay is a simple function that takes in a integer number x, and calls Thread.sleep(x) in a try catch loop. Its not very complicated function, but I use it so often for testing that I made it seperate program
print is a simple function that takes in any of the following strings, ints, floats, booleans, arrays of all of those types, and lists of string arrays and prints them out
The main inspiration for the print was how elegant python's "print" command is, and how clunky typing "System.out.print" felt after taking a class in python
