## exercise 2

Details: 

noww, first we will start with listing out the requirements as per our understanding. 

Requirements (what we plan to do): 
1. Each task has description, start time, end time, priority level
2. Add, delete, update, view tasks & details 
3. view tasks by sorted time
4. no overlaps 
5. mark tasks complete (not DELETE, atleast as per user)
6. filter by priority 


### We will ensure to code our application based on following:- 
Need to comply : (followed)
- SOLID design principles
    - Single responsibility - one class, one responsibility
    - Open / closed -> can extend without changing current code
    - Liskov Substitution - substitute subclass for parent (can generate only using task class, no need to call the factory interface)
    - Interface segregation - different actions - different interfaces 
    - dependency inversion - abstracts should be common. (you can depend only on abstracts not implementations)
- design patterns (follwed, mentioned below)
- oops 
Good to have: 
- long term running & user ip (done)
- logging (done)
- exception (done)

    
### Design patterns 
1. Interpretor - we will have to use interpretor design pattern here - to get the input from the user. 
2. singleton - one time manager -> to ensure no overlap 
3. factory 
4. observer - notifications for conflicts (checks for conflict when new task is being added) 

# Steps followed 
### 1. Make a task factory first & create the task template
### 2. Implement the interpretor as follows

To make it easy for the user - 
we will have the interpretor interpret user inputs as follows 
viz - 
 implementation
First word 
1. create / add /  c / a => create a new task 
    - 1.1 Second word
        Task name (must be within " " if more than one word)
    - 1.2 Third word 
        start time : **MUST BE IN HH:MM format ONLY" (24H)
    - 1.3 Fourth word 
        end time : same rules 
    - 1.4 Fifth word
        priority : if not given - assume medium (and inform it to user)
            high/h
            medium/m 
            low/l 
2. remove / delete / r / d => deletes a task
    - 2.1 next words
        Task name 
3. edit / update / e / u => edit an existing task 
    - 3.1 second word 
        task name (must be within " " if more than one word)
    - 3.2 third word 
        n (name) / st (for start time) / et (end time) / p (priority)
    - 3.4 fourth word 
        new string to be updated 
4. view / list / v / l
 => view the list of all tasks, as a table sorted by time
    If you want to filter by priority just type the priority near it 
    4.1 second word
        represents priority (h/l/m)
5. exit / quit to close the application
6. help / h to see this menu 
7. done => followed by task name -> marks the task as done
8. undo => followed by task name -> brings back the task if no conflict. 
9. ld => lists all the completed tasks 
All of these are NOT case sensitive

IF ANY OF THE INPUT IS INVALID. dont proceed after interpretor - simply inform the user and reprompt. 
--> Validate time too, with start hour, end hour, etc. (dates are NOT considered)

### 3. Create a central repo to store all tasks 
    Also create another Archive repo - to store completed todos (used for _____ )
    This is done using the taskRepo where we have two lists - tasksList and archivedTasks (while storing, we do not store it sorted based on anything -> this is handled later)

### 4. Observer needs to check for name conflict 
    in taskRepo we have a method that check if a taskExists everytime when we update, unarchive or create a new task. 
    All the error messages are said to the users. 

### 5. Add 'done' functionality and undo functionality
    (cannot retrive deleted though) -> if we want, we can store those in a recycle bin and save it for 30 days. 
    archivedTasks has the completed todos.

    in the interpretor, when the user says, 
    --> "done taskName" (format similar to remove)
    --> we move it to archived tasks 

    When they say 
    --> "undo taskName" (format similar to remove)
    --> we try adding it again, and it will be added if a task doesn't exist in that name already. 

    When they want to see completed tasks 
    --> "ld"

    (add all the above to in the interpretor class)

    Next steps: archived Tasks is cleared after certain time

### 6. Maintain a timeline to see conflicts in time. 
    This needs to be a singleton time manager
    Here we are having an array of 0s. each cell representing one minute. 
    we are using an array of length 24*60 for this. 
    blocked values are represented with 1. 
    when deleting and archiving we are freeing it
    when creating, updating, unarchiving, we are checking if they are free and then block the time if free. 

### 7. sorting based on time
    in the display all and display with filter, we have to sort based on starting time alone 
    this function is updated in the taskRepo. 

Next steps to rectify: Updating start time and end time of tasks without conflict. Need to remove the task and then fit in the new task to check if time conflicts or not. 

