package unit;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Particle {
    // A simple Particle class

    Vec position;
    Vec velocity;
    Vec acceleration;
    float lifespan;
    PApplet app;
    PImage unit;

        Particle(Vec l, PApplet app) {
            this.app = app;
            acceleration = new Vec(0, 0.005f);
            velocity = new Vec(app.random(-1, 1), app.random(-1, 1));
            position = l.copy();
            lifespan = 100.0f;
            unit = app.loadImage("Drawing2.png");
        }

        void run() {
            update();
            display();
        }

        // Method to update position
        void update() {
            acceleration = new Vec(0, (float) Math.sin(lifespan)+0.02f);
            velocity.add(acceleration);
            position.add(velocity);
            lifespan -= 1.0;
        }

        // Method to display
        void display() {
            app.stroke(255, lifespan);
            app.fill(255, lifespan);
//            app.ellipse(position.x, position.y, 0.5f, 0.5f);
//            app.image(unit,position.x, position.y);
        }

        // Is the particle still useful?
        boolean isDead() {
            return (lifespan < 0.0);
        }
}
