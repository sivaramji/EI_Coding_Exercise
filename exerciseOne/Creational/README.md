We will see the following two types of patterns in creational in detail. 

We will take the example of astronauts here for all the patterns. 

### Examples explained 
#### 1. Factory 
Let's assume there is a space food factory - And, the astronauts has to order food daily through an application we develop. 

----> It is inefficient to make them order spaceMangoMilkShake spaceVanillaMilkShake as separate objects 
i.e. new mangoMilkShake(), new vannilaMilkShake() is redudant if they are two separate classes. 

----> Implementation 
We have a spaceMilkShakeFactory which can provide the astronaut with any milkShake they want as most of the implementation remains the same. 
In this factory, we decide what milkshake to make, and NOT at the main. the task is delegated to a 'factory' which can make similar products. 

If we want to combine similar steps of each milkshake, we can implement the spaceMilkShake interface to a class where we do the common steps and inherit (extend) the specific milk shake types from this class. - not under the scope of factory method. (Reference to Structural Pattern - Flyweight) 

#### 2. Abstract 
This is very similar to factory - but we order the factories as a whole here. 
For example, if I have saved morning breakfast as 
- Dosa + Mango milkshake. 
Afternoon as 
- Sambar + chocolate milkshake. 
Then, I can have a simple function like serveMeals and get the inputs as 'breakfast' or 'lunch'. 

Here breakfast and lunch are classes. We can update these classes later, so that user input values can be updated here. (For now we have assumed specific items)

There is a spaceFood package inside Abstract, which is also implemented based on factory pattern. 

When we call serveMeals function - we take in the time input - breakFast or Meals, and then we serve their stored preferences from before. 

___

Here if you make the milkshake using .addMilk().addFlavour("Mango"), kind of steps - it is the builder design pattern. 
