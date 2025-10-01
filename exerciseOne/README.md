Readme file for Exercise One (Overall)


Please look in following order: Creational -> Structural -> Behavioural

### # Exercise 1 
## Design Patterns 

What is it? any resuable solution or blueprint. An idea to adapt. 

Quick summary - 
1. Creational - how objects are created
2. Structural - how objects combine
3. Behavioural - how objects communicate

These patterns need to be _reusable_ , _standard_ ( for e.g. with comments to understand ), _efficient_ (dont solve same problem twice), _flexible_ 

## 1. Creational Pattern 
1. Factory - single factory (class) that makes 'similar' objects. Order anything you want from this factory, not the particular class itself. 
2. Abstract - when you want to order a factory that has similar objects. e.g. mac and windows, both needs buttons (same function) - but comes from different factory. 
3. Builder - step by step process instead of as a whole. => Can use when we customize a lot. 
4. Prototype - make a copy of what's there already. (like ctrl+D)
5. Singleton - only one instance ALWAYS. 

--> Use cases are explained in the README files of respective design pattern's folder. 

## 2. Structural Pattern 
There are 7 types - how objects combine. 
1. Adapter - fit two incompatible classes together. 
2. Bridge - decouple the client from the implementation (much like how we used an interface to connect the specific types to the factory in Creational pattern)
3. Composite - allows you to combine more than objects. e.g. Used while billing, when we combine more than one object. 
4. Decorator - add features at runtime. - e.g. adding toppings (like in swiggy -> we can use builder creational pattern to implement it) after the milkshake is created. 
5. Facade - deception -> make things abstract to the user. e.g. astronaut doesnt need to know if we have stocked our pantry with mangoes. 
6. Flyweight - (from boxing - lighweight, efficient, no unnecessary bulk) - Combine similar steps together & reuse! 
7. Proxy - placeholder for another object. Adds a layer of control. e.g. usually used in access control. -> to check if i can access an object/ used when we call an object remotely (possibly from a client?)

-- In this, we will demonstrate flyweight (extension of factory from creational) and decorator by adding toppings to our milkshakes. 

## 3. Behavioural 
11 patterns are there to design communications between objects. 

1. Chain of responsibility - single process passes through various objects -> e.g. when the milkshake is ordered -> we will need the billPayments to be made, then the notification to blender to be sent, then serving to be done by the robot. (passes through various objects doing different work)
2. Command Pattern - decouples sender and receiver. sender doesn't need to know how the implementation is done. -> Treat actions as objects (connects different process). e.g. In our 2nd implementation (Decorators) in Structural (where we added toppings), we had buildAndServeShake. Here, user didn't know what happens inside, but just the fact taht milkShake is served. 
3. Interpreter - basic sentence parser to commands. Instead of asking the user to input mango as base shake, choco chips as toppings -> they can simply do mango + choco chips and we have to parse it by splitting at '+' and with indices we can find out the corresponding params. 
4. Iterator - be it any type of collection, without knowing whatever it is, we can iterator through any of it. 
5. Mediator - sort of a manager, which is there centrally, to communicate between various objects. 
6. Memento - for remembrance! (used in undo, redo functions) - store the current status; you can even log it. 
7. Observer - one change - notification is done to all. e.g. if the blender is broke, you have to make all the milk shakes (in a list) unavailable in the listing. 
8. State - useful to set current status of an object e.g. Blender can be blending or ready to blend or failed. 
9. Strategy - instead of something that happens always, depending on situation - different objects are called (best case is found using any smart algo).
10. Template - we usually know what to do in general (steps to follow) e.g. to make milkshake - add milk, add ice cream, add flavour, shake, add topping, serve. If these steps are encapsulated to a single then, then it's a template to make ANY MILKSHAKE!! 
11. Visitor - add new operations to cls without modifying them. -> this goes to list of classes and does the same job - for e.g. fetch calories of all milkshakes. 

-- we will make a visitor and template now for the spaceMilkShake! 

-------
Now we will see how we can use these patterns and create the todo app for our astronaut!! 