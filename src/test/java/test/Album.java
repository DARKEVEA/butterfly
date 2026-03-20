package test;

import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PImage;

public class Album extends PApplet {
    PImage img;
    int numRings = 6;                  // 圆环数量
    float ringWidth;                     // 每个圆环的宽度
    float[] angles;                      // 每个圆环的当前旋转角度
    int rotationPeriod = 400;            // 旋转一周所需的帧数
    int halfPeriod = rotationPeriod / 2; // 每个阶段的时间（帧数）

    public void setup() {

        img = loadImage("album.jpg"); // 替换为你的图像路径

        // 确保图像是正方形
        img.resize(width, height);

        // 初始化每个圆环的旋转角度
        angles = new float[numRings];
        for (int i = 0; i < numRings; i++) {
            angles[i] = 0;
        }

        ringWidth = width / (2 * numRings); // 计算每个圆环的宽度
    }

    public void draw() {
        frameRate(120);
        background(255);

        // 将图像遮罩成圆形
        PGraphics mask = createGraphics(width, height);
        mask.beginDraw();
        mask.background(0);
        mask.noStroke();
        mask.fill(255);
        mask.ellipse(width / 2, height / 2, width, height);
        mask.endDraw();

        PImage maskedImage = img.get();
        maskedImage.mask(mask);

        // 计算当前阶段进度
        int currentFrame = frameCount % rotationPeriod;
        boolean isFirstPhase = currentFrame < halfPeriod; // 判断是否处于第一阶段
        float phaseProgress = (currentFrame % halfPeriod) / (float)halfPeriod;

        for (int i = 0; i < numRings; i++) {
            float innerRadius = i * ringWidth;
            float outerRadius = (i + 1) * ringWidth;

            // 平滑的速度控制，使用正弦函数控制每个阶段的速度变化
            float speedFactor;
            if (isFirstPhase) {
                // 第一阶段：使用sin函数使内层较慢、外层较快（0到π/2）
                speedFactor = map(i, 0, numRings - 1, 0.5f, 1.5f) * sin(phaseProgress * HALF_PI);
            } else {
                // 第二阶段：内层较快、外层较慢（π/2到π）
                speedFactor = map(i, 0, numRings - 1, 1.5f, 0.5f) * sin(phaseProgress * HALF_PI + HALF_PI);
            }
            float baseSpeed = TWO_PI / rotationPeriod;           // 基础速度，确保每圈用rotationPeriod帧旋转一周
            float speed = baseSpeed * speedFactor;               // 动态速度

            // 更新旋转角度
            angles[i] += speed;

            // 限制角度到 0 到 2*PI 之间，以便在旋转完一周后重置
            angles[i] = angles[i] % TWO_PI;

            pushMatrix();
            translate(width / 2, height / 2);
            rotate(angles[i]);  // 每个圆环的旋转角度

            // 使用遮罩绘制单个圆环
            PGraphics ringMask = createGraphics(width, height);
            ringMask.beginDraw();
            ringMask.background(0);
            ringMask.noStroke();
            ringMask.fill(255);
            ringMask.ellipse(width / 2, height / 2, outerRadius * 2, outerRadius * 2);
            ringMask.fill(0);
            ringMask.ellipse(width / 2, height / 2, innerRadius * 2, innerRadius * 2);
            ringMask.endDraw();

            PImage ringImage = maskedImage.get();
            ringImage.mask(ringMask);
            image(ringImage, -width / 2, -height / 2);

            popMatrix();
        }

//        saveFrame("frame19/####.png");
    }



    public void settings() {
        size(1200,1200);
    }

    public static void main(String[] args) {
        PApplet.main("test.Album");
    }
}
