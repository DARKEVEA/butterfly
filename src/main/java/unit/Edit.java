package unit;

import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;

public class Edit {

    int unitNum;
    double unitLife;
    float angle = 0;
    PApplet app;
    PImage img;
    ArrayList<Vec> unitArrayList = new ArrayList<>();

    float[] xPosM,yPosM,extentM;
    int[] cM,alphaM;
    double[] speedX,speedY;
    Vec[] speed;

    public Edit(int unitNum, double unitLife, PApplet app, PImage img){
        this.unitLife = unitLife;
        this.unitNum = unitNum;
        this.app = app;
        this.img = img;

        xPosM = new float[unitNum];
        yPosM = new float[unitNum];
        extentM = new float[unitNum];
        cM = new int[unitNum];
        alphaM = new int[unitNum];
        speedX = new double[unitNum];
        speedY = new double[unitNum];
        speed = new Vec[unitNum];

        this.initUnit();
//        this.displayUnit();
//        this.updateUnit();
//        this.rhombicUnit();
    }

    public void initUnit(){
        for (int i =0; i < unitNum; i++){
            xPosM[i] = app.width/2 + (int)(app.randomGaussian() * app.width/3);
            yPosM[i] = (int)app.random(app.height);
            cM[i] = img.get((int)xPosM[i], (int)yPosM[i]);
            extentM[i] = (float) (app.randomGaussian()*2.5f);
//            extentM[i] = 2;
            alphaM[i] = (int)app.map(app.randomGaussian(),0,1,0,100);
//            System.out.println(cM[i]);
//            this.displayUnit();
        }

//        app.pushMatrix();
//        app.translate(xPosM[0],yPosM[0]);
//
//        app.rotate(app.randomGaussian()*30);
//        app.scale((float) (extentM[0]*0.01));
//
//        app.image(unit,-unit.width/2,-unit.height/2);
//        app.popMatrix();
    }

    public void displayUnit(){
        for (int i = 0; i < unitNum; i++){
            if (cM[i] != -1){
                app.pushStyle();
                app.colorMode(app.HSB);
                app.noStroke();
//                app.fill(app.map(yPosM[i],0,app.height,200,255));
//                app.fill(app.map(Math.abs(xPosM[i]-app.width/2),0,app.width/2,150,220),155,255,50);
//                app.fill(cM[i]);
                app.fill(app.map(Math.abs(xPosM[i]-app.width/2),0,app.width/2,140,200),155,255);

                app.circle(xPosM[i],yPosM[i],extentM[i]);
                app.popStyle();


//                app.pushMatrix();
//                app.translate(xPosM[i],yPosM[i]);
//
//                app.rotate(time);
//                app.scale((float) (extentM[i]*0.01));
//
//                app.image(unit,-unit.width/2,-unit.height/2);
//                app.popMatrix();

//                unitLife += 0.01;
            }
        }
    }

    public void displayUnit1(int indexUnit){
        app.pushStyle();
        app.pushMatrix();
        app.translate(xPosM[indexUnit],yPosM[indexUnit]);
        float angle0 = app.brightness(cM[indexUnit]);
        float angle1 = app.map(angle0,0,255,0,100);
        float angle2 = app.map(angle0,0,255,100,255);
        app.rotate(angle1+app.random(0.5f)-0.2f);
        System.out.println(angle0);
        app.strokeWeight(app.random(2,5));
        if (angle1 > 99.9){
            app.stroke(200,200,200);
        }
        else if(angle0 < 100){
//            app.colorMode(app.HSB);
            app.stroke(16,17,12,app.random(100,255));
        }
        else {
            app.stroke(88,228,215,app.random(100,255));
        }
//        app.stroke(cM[indexUnit],app.random(150,255));
        app.line(-app.random(app.random(50)),0,app.random(app.random(50)),0);
        app.popMatrix();
        app.popStyle();
    }

    public void updateUnitPhase1(float time){
        for (int i = 0; i < unitNum; i++){
            float theta = app.noise((float) (xPosM[i]*0.01) , (float) (yPosM[i]*0.01)) * app.TWO_PI;

            //原地转圈
            speedX[i] = 0.35 * app.cos(20*theta) *time*0.3;
            speedY[i] = 0.35 * app.sin(20*theta) *time*0.3;

//            //原地转圈
//            speedX[i] = -1 * app.cos(theta * app.random(0.5f)) + app.sin(theta* app.random(0.5f));
//            speedY[i] = -1 * app.sin(theta* app.random(0.5f));

            xPosM[i] += speedX[i];
            yPosM[i] += speedY[i];

            if (cM[i] == -1){
                xPosM[i] = app.width/2 + (int)(app.randomGaussian() * app.width/3);
                yPosM[i] = (int)app.random(app.height);
                cM[i] = img.get((int)xPosM[i], (int)yPosM[i]);
            }

        }
    }

    public void updateUnitPhase2(float time){
        for (int i = 1; i < unitNum; i++){
//            xPosM[i] += app.randomGaussian()*0.1;
//            yPosM[i] += app.noise(PApplet.sin(yPosM[i-1]));
//            if (cM[i] != -1){
                int t = (int)(time/10) + 1;
                float theta = app.noise((float) (xPosM[i]*0.005*t) , (float) (yPosM[i]*0.005*t)) * app.TWO_PI ;
                float k = app.map(i,0,unitNum,0,1);

//            //水墨上行
//            if (i % 3 == 0 ){
//                speedX[i] = -1 * app.cos(theta * (float)Math.floor(time/10)) * time * 0.03;
//                speedY[i] = -1 * app.sin(theta * (float)Math.floor(time/10)) * time * 0.03;
//            }
//            //原地转圈
//            if (i % 5 == 0){
//                speedX[i] = -1 * app.cos(theta* (float)Math.floor(time)) ;
//                speedY[i] = -1 * app.sin(theta* (float)Math.floor(time)) ;
//            }
//            //原地转圈
//            else{
//                speedX[i] = -0.5* app.cos(theta * (float)Math.floor(time));
//                speedY[i] = -1* app.sin(theta * (float)Math.floor(time));
//
//            }

            //水墨上行
            if (i % 3 == 0 ){
                speedX[i] = -1 * app.cos(theta * time *k) * time * 0.03;
                speedY[i] = -1 * app.sin(theta * time *k) * time * 0.03;
            }
            //原地转圈
            if (i % 5 == 0){
                speedX[i] = -1 * app.cos(theta* time*k) ;
                speedY[i] = -1 * app.sin(theta* time*k) ;
            }
            //原地转圈
            else{
                speedX[i] = -0.5* app.cos(theta * time*k);
                speedY[i] = -1* app.sin(theta * time*k);

            }


//                //原地转圈
//                speedX[i] = -1 * app.cos(20 * theta) * (1 / (1 - Math.pow(Math.E,-(time-10))));
//                speedY[i] = -1 * app.sin(20 * theta) * (1 / (1 - Math.pow(Math.E,-(time-10))));

                speed[i] = new Vec((float) speedX[i],(float) speedY[i]);
                Vec point = new Vec(0,1);
                if (i == 1){
                    angle = speed[i].angle(point);
                    angle = speed[i]._toAngle(angle);
//                    System.out.println(angle);
                }else {
                    angle = speed[i].angle(speed[i-1]);
                    angle = speed[i]._toAngle(angle);
//                    System.out.println(angle);
                }


//            if (xPosM[i] < app.width/2){
//                xPosM[i] +=  app.cos(theta)+app.cos(20*theta);
//                yPosM[i] +=  app.sin(theta)-app.sin(20*theta);
//            }
//            else {
                xPosM[i] += speedX[i];
                yPosM[i] += speedY[i];
//            }



//                if (img.get((int)xPosM[i],(int)yPosM[i]) == -1){
//                    speedX = speedX * 5;
//                    speedY = speedY * 5;
//                    System.out.println("speed change!");
//                }
//            }
        }
    }
}
