package test;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;
import unit.ParticleSystem;
import unit.Vec;

import java.util.ArrayList;

public class Test04 extends PApplet {
    /**
     * Multiple Particle Systems
     * by Daniel Shiffman.
     *
     * Click the mouse to generate a burst of particles
     * at mouse position.
     *
     * Each burst is one instance of a particle system
     * with Particles and CrazyParticles (a subclass of Particle).
     * Note use of Inheritance and Polymorphism.
     */

    ArrayList<ParticleSystem> systems;
    PImage underMap,universe;
    Vec[] v;
    int numDot = 100;

    public void setup() {
        underMap = loadImage("underMap.jpg");
        universe = loadImage("5347.png");
        underMap.resize(width,height);
        universe.resize(width,height);
        systems = new ArrayList<ParticleSystem>();

        v = new Vec[numDot];
        v[0] = new Vec(-1000,-1000);
        for (int i = 1; i< numDot; i++){
            Vec seed = new Vec(random(width),random(height));
            int c = underMap.get((int)seed.x,(int)seed.y);
            if (c != -1){v[i] = seed;}
            else v[i] = v[i-1].copy();
        }
        systems.add(new ParticleSystem(1,v,this,numDot));

//        image(universe,0,0);
    }

    public void draw() {
//        background(0);
        image(universe,0,0);
//        fill(20,50);
//        rect(0,0,width,height);
        for (ParticleSystem ps : systems) {
            ps.run();
            ps.addParticle();
        }

//        saveFrame("frame5/####.png");
    }

    public void settings(){
        size(1600, 900);
    }


    public static void main(String[] args) {
        PApplet.main("test.Test04");
    }
}
