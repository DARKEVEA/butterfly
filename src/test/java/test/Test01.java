package test;

import processing.core.PApplet;
import processing.core.PImage;
import unit.Edit;

public class Test01 extends PApplet {

    PImage underMap,universe,unit01,unit02,unit03;
    Edit edit;
    int unitNum = 25000;
    double unitLife = 0.1;
    float time = -20;
    int count = 0;

    public void setup(){
        underMap = loadImage("underMap.jpg");
        universe = loadImage("demo0.png");
        unit01 = loadImage("Drawing1.png");
        underMap.resize(width,height);
        universe.resize(width,height);
//        image(universe,0,0);

        edit = new Edit(unitNum,unitLife,this,underMap);
        background(20,10);
//        image(universe,0,0);

        edit.initUnit();

//        for (int i = 0; i< unitNum; i++){
//            edit.displayUnit1(i);
//        }
    }

    public void draw(){
        frameRate(60);
//        image(universe,0,0);
//        background(255);
        fill(20,50);
        rect(0,0,width,height);

//        if (count < unitNum){
//            edit.displayUnit1(count);
//            count ++;
//        }


        if (time < 0){
            edit.displayUnit();
            edit.updateUnitPhase1(time);
            time += 0.01;
        }

        else {
            edit.displayUnit();
            edit.updateUnitPhase2(time);
            time += 0.01;
        }
//        System.out.println(time);

        if (time >= 0){noLoop();}

//        saveFrame("frame15/####.png");
    }

    public void settings(){
//        fullScreen();
        size(1600,900);
    }

    public static void main(String[] args) {
        PApplet.main("test.Test01");
    }
}
