### 1. Vistor pattern 

Now, we will have a very similar implementation to The factory pattern of Creational first and create an accept button, to allow the visitor see us. (security!!!).

Now first let's write our calorie Function - which goes to each milkshake we have and gets its calories and applies discount

Here we do not have double dispatch i.e. no accept function in all the milkShake classes. Why? we have a common interface to access all of it (using factory & bridge patterns). If we did not have that.. and say, we have milkShake and burger, then it is better off to use accept() function in both to keep it generic, instead of repeating definitions within any visitor class. 

So, we when we call discountVisitor.. essentially, we go and visit EACH of the milkshake and then apply 10% discount on each. 

Similarly, in calorieVisitor, we go to each milkShake and fetch the calories. We can do complex operations also here. 
It is useful when you have to frequently modify these objects, as a whole. 

### 2. Template 

First we will create an abstract class called milkShakeMakingTemplate. 

In this abstract class, we have a function called makeMilkShake

(This is similar to milkShakeBase class of flyweight)

Now, any shake can be a child of this template. 

For example, mango milkshake is called, and the abstract class (template) itself has the common steps of adding milk, ice cream, shaking and serving. 

But the subclasses mangoMilkShake and chocolateMilkShake has the adding the flavour and toppings functions!! 

This is how we use a template pattern. :))!!

