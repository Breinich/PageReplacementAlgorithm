# PageReplacementAlgorithm
Create a program in Java or Python that simulates the operation of a page replacement system!  

As input to the program, it receives the identifiers of pages referenced during memory operations in the order of their reference. As output, it returns the identifiers of the physical memory frames allocated as a result of the performed page swaps and the number of page faults.  

There are 3 memory frames in the system, all of which are initially empty. At departure, the sheets are located at the exchange point.  

The cards are marked with numbers (1-99), the frames with letters (A, B and C).  

## Input (standard input, stdin)
References to pages in a single line are separated by commas. For example:  

1,2,3,-1,5,-1  
Negative numbers indicate write operations on the specified page; then the frames receive a "dirty" signal (this is not relevant information for all algorithms, but it can occur in the input).  

The end of the input is indicated by EOF (it can be preceded by a line feed or an empty line). Then the result should be written to the output.  

## Output (standard output, stdout)
The first line of the output shows the letters of the memory frames reserved for servicing the input memory links in the correct order, without spaces, written together, followed by the number of page faults in the next line. There should be no blank characters or additional lines before or after the posted results!  
If a new frame did not have to be reserved for a memory link (the page was already in the memory), a "-" sign appears on the output at the given position.  
If a memory allocation cannot be fulfilled (there are no free frames and no frames can be freed), then the output shows a "*" character (the operation is not repeated by the algorithm). By definition, the latter case cannot occur with all algorithms.  

### Algorithm to be implemented  
Another Chance (SC) card exchange with a freeze for up to 3 moves  

The program displays the memory allocations according to the algorithm and the number of page faults!  
E.g. the response to the above input:  

ABC-AB  
5  

## Test data
Before the first submission, it is worth trying the following tests.  

1,2,3,5,4,2  
ABC*A-  
5  

1,2,3,2,4,3,2,1  
ABC-A--B  
5  

1,2,3,3,4,5,2,1  
ABC-ABC*  
7  

1,2,3,4,5,4,3,2,1  
ABC*AB-CA  
8  

-5,2,5,3,2,1,-3  
AB-C-A-  
4  

The handling of freeze frames is debatable. We could act as if they get another chance (i.e. end of FIFO), but that wouldn't reflect SC's intent to take usage time into account somewhere. Therefore, we leave such frames in place in the FIFO (just don't use them)! Example:  
1,2,3,4,1,5,1,3,6,3  
ABC*-B--CB  
7  
