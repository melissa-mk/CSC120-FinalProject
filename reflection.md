# CSC120-FinalProject

## Deliverables:
- Your final codebase 
- Your revised annotated architecture diagram 
- Design justification (including a brief discussion of at least one alternative you considered)
- A map of your game's layout (if applicable) _N/A_
- `cheatsheet.md` _N/A_
- Completed `rubric.md` 

## Additional Reflection Questions
- What was your **overall approach** to tackling this project?
  - I first created a blueprint/model of the Contact object. 
  - Then I created an InputValidator to handle user input validation so that contacts will be in a valid format. 
  - Then I created all the Contact handling methods in the ContactBook class: create(), search(), viewAllSorted(), previousContact(), nextContact(), count(), edit(), delete(), clear(). 
- What **new thing(s)** did you learn / figure out in completing this project?
  - File handling, to store and manipulate contact data even when program is rerun and memory is cleared
  - Regular expressions, for data validation
  - Implementing the Comparable\<T> interface, to override the default sort mechanism
- Is there anything that you wish you had **implemented differently**?
  - For the InputValidator, I could've extended the Java built-in class Validator to maintain consistent data standards. 
- If you had **unlimited time**, what additional features would you implement?
  - A graphical user interface
  - Exporting contacts in a variety of file formats (.txt, .csv, etc.)
  - A database storage instead of a file storage
  - Login and signup features so that different users can have separate contact books.
- What was the most helpful **piece of feedback** you received while working on your project? Who gave it to you?
  - "The last name is the most common sort attribute." ---Nina Saunders, when I told them I was planning to implement sort() by each attribute...which is quite unusual for a contact book.
- If you could go back in time and give your past self some **advice** about this project, what hints would you give?
  - You don't have to reinvent the wheel (e.g trying to sort contacts, implementing data validation methods)
  - The solution doesn't have  to be complicated; it can be a bunch of simple mini-solutions.
- _If you worked with a team:_ please comment on how your **team dynamics** influenced your experience working on this project.
  - _N/A_
  
**Design justification: Alternative design(s) I decided against using.**

I considered using a doubly LinkedList for the previous and next features, but I think that makes a single Contact store more data than it has to, hence using an ArrayList with more efficient sequential traversal.

I also resorted to file storage for data manipulation since the file data is stored as strings, which are less memory-intensive than Contact objects to manipulate.