This file has the overall explanation of the submissions. Detailed explanations are in the corresponding exercise's README.md files. 

# Exercise 1 
## Design Patterns 

### Summary of Use cases proposed

### 1. Creational 
1. Factory - Ordering space Milkshake
2. Abstract - Ordering space food combos based on stored preferences

### 2. Structural 
1. flyweight - similar steps are implemented only once and reused
2. decorator - adding toppings

### 3. Behavioural 
1. Visitor - one template to allow any type of changes to ALL milkshakes. 
2. Template - boiler plate to make ANY milkshake. (flyweight included - no redundant implementation) - only flavour and toppings are added in subclasses. 

# Exercise 2 

## Statement picked : 1. Astronaut Daily Schedule Organizer 

### Language Used : Java 

Focus:
Interpreting inputs with different options (e.g. create/add/a/c all resembles create)
Singleton time manager to block and free time
archiving and unarchiving tasks. 

Design Patterns majorily used in the project:-
1. Interpretor - we  use interpretor design pattern here - to get the input from the user (and process it, irrespective of how the user gives it -> meaning more than one option)
2. singleton - one time manager -> to ensure no overlap 
3. factory 
4. observer - notifications for conflicts (checks for conflict when new task is being added) 

#### --> Detailed explanation is in exerciseTwo's readme file, with screenshots. 