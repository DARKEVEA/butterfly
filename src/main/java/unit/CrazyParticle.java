package unit;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class CrazyParticle extends Particle{
    // A subclass of Particle

        // Just adding one new variable to a CrazyParticle
        // It inherits all other fields from "Particle", and we don't have to retype them!
    float theta;
    PImage unit01,unit02,unit03,unit04,unit05;

        // The CrazyParticle constructor can call the parent class (super class) constructor
        CrazyParticle(Vec l, PApplet app) {
            // "super" means do everything from the constructor in Particle
            super(l,app);
            // One more line of code to deal with the new variable, theta
            theta = 0.0f;
            unit01 = app.loadImage("unit10.png");
            unit02 = app.loadImage("unit11.png");
            unit03 = app.loadImage("unit12.png");
            unit04 = app.loadImage("unit13.png");
            unit05 = app.loadImage("unit14.png");
        }

        // Notice we don't have the method run() here; it is inherited from Particle

        // This update() method overrides the parent class update() method
        void update() {
            super.update();
            // Increment rotation based on horizontal velocity
            float theta_vel = (velocity.x * velocity.mag()) / 30.0f;
            theta += theta_vel;
        }

        // This display() method overrides the parent class display() method
        void display() {
            // Render the ellipse just like in a regular particle
            super.display();
            // Then add a rotating line
            app.pushMatrix();
            app.translate(position.x, position.y);
            app.rotate(theta/10);
            app.scale(0.2f*app.random(1,1.05f));
            app.stroke(255, lifespan);
//            app.line(0, 0, 25, 0);
            if (lifespan < 40 ){
                app.image(unit01,20, 20);
            }
            if (lifespan < 80 && lifespan >= 40){
                app.image(unit02,20, 20);
            }
            if (lifespan < 120 && lifespan >= 80){
                app.image(unit03,20, 20);
            }
            if (lifespan < 160 && lifespan >= 120){
                app.image(unit04,20, 20);
            }
            if (lifespan >= 160){
                app.image(unit05,20, 20);
            }

            app.popMatrix();
        }

}
