# killJosProblem
*This project was done in a java class*
The code is based on a famous Josephus problem in which a group of people gets attacked by their enemies and there's no way out. So they all decided to kill each other. To read more about the problem visit: https://en.wikipedia.org/wiki/Josephus_problem

In this game our task is to perdict who will be the last survivor.

I essencially created a circular linked list with a random number generator which decides that the killing game should start with person on what position.

After deciding the loop begins and starts killing off the person on the position and moves down if that position doesnt exist. With the person getting killed at a certain position all the values/postions of all survivors also change according to the circluar linked list.

When there's just one person left. The solution gets printed.
