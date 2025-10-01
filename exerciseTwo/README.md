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
Need to comply : 
- SOLID design principles
- design patterns 
- oops 
Good to have: 
- long term running & user ip 
- logging 
- exception 


### Design patterns 
1. Interpretor - we will have to use interpretor design pattern here - to get the input from the user. 
2. singleton - one time manager -> to ensure no overlap 
3. factory 
4. observer - notifications for conflicts (checks for conflict when new task is being added) 

Steps 
1. Make a task factory first 
2. Implement the interpretor as follows

To make it easy for the user - 
we will have the interpretor interpret user inputs as follows 
viz - 

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
All of these are NOT case sensitive

IF ANY OF THE INPUT IS INVALID. dont proceed after interpretor - simply inform the user and exit. 


Observer needs to check for name conflict and time conflict. 
