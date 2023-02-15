This is just an example to show how code get simplified when re-implementing the Ornamental Garden problem of Lecture 9, by using semaphores. 

Note that this is a strange use of this tool, as we have one thread acquiring and one thread releasing. In this configuration, it might be difficult to coordinate the two actions. Indeed, the execution of the main method will return a correct count of spaces available in the car park, but it might happen the the sequences of actions starts with a leave request even if the car park is empty - this will just return the maximum number of spaces available as no car can leave from an empty car park. On the contrary, in lecture 9, we wrote more verbose code but were able to avoid this by coordinating the enter() and leave() methods with wait() and notifyall() calls.

Generally, I suggest using semaphores where the methods are coordinated in the same thread.

Fabio