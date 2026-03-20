package unit;

import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public class ParticleSystem {
    // An ArrayList is used to manage the list of Particles

        ArrayList<Particle> particles;    // An arraylist for all the particles
        Vec[] origin;                   // An origin point for where particles are birthed
        PApplet app;
        int numDot;

        public ParticleSystem(int num, Vec[] v, PApplet app,int numDot) {
            this.numDot = numDot;
            particles = new ArrayList<Particle>();
            origin = new Vec[numDot];
            for (int i = 0;i < numDot; i++){
                Vec ran = new Vec(app.random(-2,2),app.random(-2,2));
                origin[i] = new Vec();
                origin[i].set(v[i].addNew(ran));
            }

            this.app = app;

            for (int i = 0; i < numDot; i++) {
                for (int j = 0; j< num; j++){
                    particles.add(new Particle(origin[i],app));
                }
            }
        }


        public void run() {
            // Cycle through the ArrayList backwards, because we are deleting while iterating
            for (int i = particles.size()-1; i >= 0; i--) {
                Particle p = particles.get(i);
                p.run();
                if (p.isDead()) {
                    particles.remove(i);
                }
            }
        }

        public void addParticle() {
            Particle p;
            // Add either a Particle or CrazyParticle to the system
            for (int i = 0; i < numDot; i++){
                Vec ran = new Vec(app.random(-2,2),app.random(-2,2));
                if (app.random(0, 2) < 1.9f)
                {
                    p = new Particle(origin[i].addNew(ran),app);
                }
                else {
                    p = new CrazyParticle(origin[i].addNew(ran),app);
                }
                particles.add(p);
            }
        }


        void addParticle(Particle p) {
            particles.add(p);
        }

        // A method to test if the particle system still has particles
        boolean dead() {
                    return particles.isEmpty();
                }

}
