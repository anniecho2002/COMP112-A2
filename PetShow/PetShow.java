/* Code for COMP-102-112 - 2021T1, Assignment 2
 * Name: Annie Cho
 * Username: choanni
 * ID: 300575457
 */

import ecs100.*;

/** Program to create simple animated animal character using the
 *  Animal class.  
 */

public class PetShow{

    /** animate creates two or several animals on the window.
     *  Then animates them according to a fixed script by calling a series
     *  of methods on the animals.
     *  
     *  CORE
     */
    public void animate(){
        Animal dog = new Animal("dog", "Dino", 500, 300);
        dog.introduce("'Ello there,");
        dog.goLeft(70);
        dog.goRight(100);
        dog.speak("And I'm your host...");
        dog.jump(30);
        dog.speak("For this season...");
        dog.jump(20);
        dog.shout("OF THE...");
        dog.shout("BACHELOR!");
        dog.goLeft(30);
        
        Animal turtle = new Animal("turtle", "Squirtle", -20, 300);
        turtle.goRight(300);
        
        dog.speak("Hi Squirtle!");
        dog.speak("You're the bachelor.");
        dog.speak("How do you feel?");
        
        turtle.think("I didn't sign up for this...");
        turtle.speak("Wonderful, thank you.");
        turtle.jump(40);
        turtle.speak("I'm excited to find love.");
        turtle.speak("Or friendship, or whatever.");
        
        dog.speak("It's the perfect show!");
        turtle.goLeft(1000);
        dog.goLeft(200);
        dog.speak("Let's welcome our");
        dog.speak("CONTESTANTS then!!!");
        dog.goRight(100);
        dog.goLeft(200);
        dog.goRight(100);
        dog.shout("CUT THE");
        dog.shout("CAMERAS!");
        dog.think("I don't get paid enough.");
    }

    /** threeAnimalsRoutine creates three animals on the window.
     *  Then makes each animal do the same routine in turn.
     *  You should define a routine method, and threeAnimalsRoutine
     *   should call the routine method three times, to make
     *   each of the three animals perform the routine in turn.
     *   
     *   COMPLETION
     */
    public void threeAnimalsRoutine(){
        Animal bird = new Animal("bird", "Hamburger", 100, 300);
        Animal grasshopper = new Animal("grasshopper", "Pecan", 350, 300);
        Animal tiger = new Animal("tiger", "Lolly", 600, 300);
        
        routine(bird);
        routine(grasshopper);
        routine(tiger);
    }

    /** makes the animal character do a little routine
     */
    public void routine(Animal object){
        object.introduce("Hi");
        object.speak("I am a contestant.");
        object.shout("DANCE TIME!");
        object.goLeft(50);
        object.goRight(100);
        object.jump(20);
        object.goLeft(50);
        object.jump(30);
        object.speak("Bye for now!");
        object.goLeft(1000);

    }
    
    /**         Animal bird = new Animal("bird", "Hamburger", 350, 300);
        Animal grasshopper = new Animal("grasshopper", "Pecan", 500, 300);
        Animal tiger = new Animal("tiger", "Lolly", 650, 300); */
    
    public void fly(Animal object){
        object.goRight(70);
        object.goLeft(70);
        object.goRight(90);
        object.jump(80);
        object.goLeft(2);
        object.jump(80);
        object.goRight(2);
        object.jump(80);
        object.goLeft(2);
        object.jump(200);
        object.jump(200);
        object.jump(200);
        object.jump(200);
        object.jump(200);
    }
    
    public void run(Animal object){
        object.goLeft(400);
        object.goRight(400);
        object.goLeft(300);
        object.goRight(300);
        object.goLeft(200);
        object.goRight(200);
    }
    
    public void ascend(Animal object){
        object.jump(300);
        object.jump(300);
        object.jump(300);
        object.jump(300);
    }
        
    public void challenge(){
        Animal dog = new Animal("dog", "Dino", 50, 300);
        Animal turtle = new Animal("turtle", "Squirtle", 200, 325);
        dog.goRight(5);
        dog.speak("Are you ready?");
        turtle.speak("Yes, I am!");
        dog.speak("In that case,");
        dog.speak("Let's welcome...");
        dog.shout("Hamburger!");
        turtle.goRight(5);
        
        Animal bird = new Animal("bird", "Hamburger", 1000, 300);
        bird.goLeft(500);
        bird.speak("Hi! Nice to meet you!");
        turtle.jump(20);
        turtle.jump(-20);
        turtle.speak("Any special talents?");
        bird.speak("Watch this!");
        fly(bird);
        
        dog.speak("Unimpressive.");
        turtle.speak("No rose for her.");
        dog.shout("Next!");
        
        Animal grasshopper = new Animal("grasshopper", "Pecan", 1000, 300);
        grasshopper.goLeft(500);
        grasshopper.speak("I saw that!");
        grasshopper.speak("I can do that too!");
        dog.speak("Wait-");
        turtle.speak("Please, don't-");
        fly(grasshopper);
        
        turtle.goLeft(5);
        turtle.speak("...");
        dog.speak("This is terrible.");
        turtle.goRight(5);
        grasshopper.jump(-200);
        grasshopper.jump(-200);
        grasshopper.jump(-200);
        grasshopper.jump(-200);
        grasshopper.jump(-200);
        grasshopper.speak("I'm so sorry!");
        grasshopper.speak("What about this?");
        run(grasshopper);

        grasshopper.goLeft(5);
        grasshopper.speak("You saw that right!");
        grasshopper.speak("I can run on the air!");
        
        dog.speak("That's not impressive.");
        turtle.speak("Yeah, you're a grasshopper.");
        grasshopper.speak("This is discrimination.");
        dog.shout("W H A T.");
        
        Animal tiger = new Animal("tiger", "Lolly", 1000, 300);
        tiger.goLeft(650);
        tiger.speak("Hi everyone!");
        tiger.speak("Is this live television?");
        tiger.speak("Ooh, my mum will see this!");
        
        dog.speak("What can you do?");
        tiger.speak("Hahaha!");
        tiger.shout("Everything.");
        grasshopper.jump(-250);
        tiger.jump(350);
        
        run(tiger);
        tiger.goRight(40);
        tiger.goLeft(2);
        tiger.speak("Bow before me,");
        tiger.shout("Peasants!");
        
        grasshopper.speak("Hey!");
        grasshopper.speak("She copied me!");
        tiger.speak("Copycat is my middle name.");
        
        dog.speak("I've had enough!");
        turtle.goLeft(2);
        turtle.speak("I have to give a rose,");
        turtle.speak("to SOMEONE.");
        turtle.speak("We'll lose funding!");
        turtle.goRight(2);
        turtle.speak("Lolly, come down.");
        
        tiger.speak("I can copy the bird too.");
        fly(tiger);
        dog.speak("Oh. My. God.");
        turtle.speak("That was pretty good.");
        
        dog.speak("I'm going now.");
        dog.speak("You're on your own.");
        dog.goLeft(400);
        
        grasshopper.speak("Come up with me, Squirtle.");
        turtle.goRight(225);
        ascend(grasshopper);
        turtle.speak("Maybe I'll keep the rose.");
        turtle.speak("I wanna ascend too.");
        ascend(turtle);
        
        
        

    }

    /** Make buttons to let the user run the methods */
    public void setupGUI(){
        UI.initialise();
        UI.addButton("Clear", UI::clearGraphics );
        UI.addButton("Animate", this::animate );
        UI.addButton("Three", this::threeAnimalsRoutine );
        UI.addButton("Challenge", this::challenge );
        UI.addButton("Quit", UI::quit );
        UI.setDivider(0);       // Expand the graphics area
    }

    public static void main(String[] args){
        PetShow ps = new PetShow();
        ps.setupGUI();
    }
}

