package test;

import processing.core.PApplet;
import processing.core.PImage;
import unit.Edit;

public class Test02 extends PApplet {

    PImage underMap,underMapxxxx;
    PImage unit01,unit02,unit03,unit04,unit05;
    Edit edit;
    int unitNum,n = 0;
    double unitLife = 0.1;
    double seed;

    float xPos,yPos;
    int c;

    public void setup(){
        underMap = loadImage("underMap1.jpg");
        underMap.resize(width,height);
        underMapxxxx = loadImage("underMap2.jpg");
        underMapxxxx.resize(width,height);

        unit01 = loadImage("unit01.png");
        unit02 = loadImage("unit02.png");
        unit03 = loadImage("unit03.png");
        unit04 = loadImage("unit04.png");
        unit05 = loadImage("unit05.png");

//        background(30);
        image(underMapxxxx,0,0);


        for (int k = 0; k < 15000; k++){
//            xPos = width/2 + randomGaussian() * width/2;
//            yPos = height/2 + randomGaussian() * height/2;
//            c = underMap.get((int)xPos,(int)yPos);
////            float b = brightness(c);
////            System.out.println(b);
//            seed = random(width * 5);
//
//            if (c != -1){
//                pushMatrix();
//                translate(xPos,yPos);
//                scale(randomGaussian() * 0.005f * (width - dist(xPos,yPos,width/2,height/2)) * 0.001f);
//                rotate(map(randomGaussian(),-1,1,-90,90));
//                if (seed < width){
//                    image(unit01,-unit01.width/2 + random(50),-unit01.height/2 + random(50));
//                }
//                if (seed < width*2 && seed > width){
//                    image(unit02,-unit02.width/2 + random(20),-unit02.height/2 + random(50));
//                }
//                if (seed < width*3 && seed > width*2){
//                    image(unit03,-unit03.width/2 + random(50),-unit03.height/2 + random(20));
//                }
//                if (seed < width*4 && seed > width*3){
//                    image(unit04,-unit04.width/2 + random(20),-unit04.height/2 + random(20));
//                }
//                if (seed > width*4){
//                    image(unit05,-unit05.width/2 + random(20),-unit05.height/2 + random(120));
//                }
//
//                popMatrix();
//            }
        }

//        save("demo.png");
    }

    public void draw(){
        frameRate(1800);
//        xPos = width/2 + randomGaussian() * width/2;
//        yPos = height/2 + randomGaussian() * height/2;
//        c = underMap.get((int)xPos,(int)yPos);
//        seed = random(width * 5);
        xPos = width/2 + randomGaussian() * width/2;
        yPos = height/2 + randomGaussian() * height/2;
        c = underMap.get((int)xPos,(int)yPos);
//            float b = brightness(c);
//            System.out.println(b);
        seed = random(width * 5);
//
////        if (c != -1){
////            pushStyle();
////            noStroke();
////            fill(c);
////            circle(xPos,yPos,randomGaussian()*10);
////            popStyle();
////        }
////        else {
////            pushStyle();
////            noStroke();
////            fill(c);
////            circle(xPos,yPos,randomGaussian()*3);
////            popStyle();
////        }
//
        if (c != -1){
            pushMatrix();
            translate(xPos,yPos);
            scale(randomGaussian() * 0.005f * (width - dist(xPos,yPos,width/2,height/2)) * 0.001f);
            rotate(map(randomGaussian(),-1,1,-90,90));
            if (seed < width){
                image(unit01,-unit01.width/2 + random(50),-unit01.height/2 + random(50));
            }
            if (seed < width*2 && seed > width){
                image(unit02,-unit02.width/2 + random(20),-unit02.height/2 + random(50));
            }
            if (seed < width*3 && seed > width*2){
                image(unit03,-unit03.width/2 + random(50),-unit03.height/2 + random(20));
            }
            if (seed < width*4 && seed > width*3){
                image(unit04,-unit04.width/2 + random(20),-unit04.height/2 + random(20));
            }
            if (seed > width*4){
                image(unit05,-unit05.width/2 + random(20),-unit05.height/2 + random(120));
            }

            popMatrix();
        }
//        if (c != -1){
//            pushMatrix();
//            translate(xPos,yPos);
//            scale(randomGaussian() * 0.06f * dist(xPos,yPos,width/2,height/2) * 0.002f);
//            rotate(map(randomGaussian(),-1,1,-90,90));
//            if (seed < width){
//                image(unit01,-unit01.width/2,-unit01.height/2);
//            }
//            if (seed < width*2 && seed > width){
//                image(unit02,-unit02.width/2,-unit02.height/2);
//            }
//            if (seed < width*3 && seed > width*2){
//                image(unit03,-unit03.width/2,-unit03.height/2);
//            }
//            if (seed < width*4 && seed > width*3){
//                image(unit04,-unit04.width/2,-unit04.height/2);
//            }
//            if (seed > width*4){
//                image(unit05,-unit05.width/2,-unit05.height/2);
//            }
//
//            popMatrix();
//        }
//
        unitNum ++;
        if (unitNum > 15000){noLoop();}
    }

    public void mousePressed(){
        save("demo" + n + ".png");
        n++;
    }

    public void settings(){
        fullScreen();
//        size(1920,1080);
    }

    public static void main(String[] args) {
        PApplet.main("test.Test02");
    }
}
