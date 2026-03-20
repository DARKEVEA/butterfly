package test;

import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;

public class TestAlbum extends PApplet {

    PImage img, maskImage;
    PImage imgTest;
    ArrayList<PImage> images = new ArrayList<>();
    int n = 5;
    float radius;

    @Override
    public void setup() {
        img = loadImage("src/main/resources/album.jpg");
        maskImage = loadImage("src/main/resources/mask.jpg");
        img.resize(width,height);
        maskImage.resize(width,height);
        img.mask(maskImage);

        imgTest = loadImage("src/main/resources/album.jpg");
        imgTest.resize(width/2,height/2);

        background(255);

    }

    @Override
    public void draw() {
//        frameRate(1);

        pushMatrix();
        translate(width/2,height/2);
        rotate(frameCount*PI/3000);
        imageMode(CENTER);
        image(img,0,0);
        popMatrix();

        pushMatrix();
        translate(width/2,height/2);
        rotate(-frameCount*PI/3000 + PI/10);
        imageMode(CENTER);
        image(imgTest,0,0);
        popMatrix();

//        loadPixels();
//        for (int i = 0; i < width; i++){
//            for (int j = 0; j < height; j++){
//                radius = dist(i,j,width/2,height/2);
//                if (radius > 200){
//                    pixels[i+j*width] = pixels[(int)(radius*cos(frameCount*PI/600)+width*(j+radius*sin(frameCount*PI/600)))%(width*height)];
//                }
//            }
//        }
//        updatePixels();
    }

    @Override
    public void settings() {
        size(1000,1000);
    }

    public static void main(String[] args) {
        PApplet.main("test.TestAlbum");
    }
}
