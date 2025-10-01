### 1. Flyweight 

(Please see Creational patterns first)
We have a milkshake factory which can make different milkshakes and now, we are using flyweight to 'reuse' what same class / methods and only add the respective flavours at the end! 

in this, we have a method called createBase() within the milkShakeBase. 
milkShakeBase is an implmentation of spaceMilkShake which is an interface **(Bridge Structure design pattern)**

So, when we call mango milkshake, we "reuse" the createBase to add milk and icecream as it's common to all space milkshakes! wow. 


### 2. Decorators 

Now, we will exactly import the flyweight package as such into decorators. 
Above that, we will add the toppings, as per choice, once the milkshake is made. 

- It is just modifying our ice cream in run time. 

Essentially, instead of make mangoMilkShakeWithChocoChips() as a separate class or choice, we are first creating the mango milkShake and then call addChocoChips in the milkShakeWithChocoChips function. 

But the customer knows only that, the shake is made - not how toppings are added. 

Essentially - IRRESPECTIVE of the milk shake base (it can be mango, chocolate, etc) - the milkShakeWithChocoChips will have that base shake we chose with choco chips on top of it! -> We are adding choco chips to it in runtime!

Why it's runtime? - user can separately ask me to add choco chips, even when I'm processing the base milk shake. 

Note: This example of decorators is an example of Command Pattern (Behavioural) too. (Referred in common Readme of exercise 1)