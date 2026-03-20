package unit;

import processing.core.PApplet;

/**
 * TODO
 *
 * @author libiao
 * @version 1.0
 * @date 2023/3/2 8:58
 * Inst. AAA, S-ARCH, Southeast University
 */
public class Vec {
    public float x, y, z;

    /**
     * */
    public Vec() {
    }

    /** init Vector by x, y
     * @param x: x-coordinate
     * @param y: y-坐标
     * */
    public Vec(float x, float y) {
        this.x = x;
        this.y = y;
        this.z = 0;
    }
    /** init Vector by x, y, z
     * @param x x-coordinate
     * @param y y-坐标
     * @param z z-coordinate
     * */
    public Vec(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public Vec add(Vec v) {
        this.x += v.x;
        this.y += v.y;
        this.z += v.z;
        return this;
    }
    public Vec addNew(Vec v) {
        float x = this.x +v.x;
        float y = this.y + v.y;
        float z = this.z + v.z;
        return new Vec(x, y, z);
    }
    public Vec addNew(float x, float y, float z) {
        float xx = this.x + x;
        float yy = this.y + y;
        float zz = this.z + z;
        return new Vec(xx, yy, zz);
    }
    public Vec sub(Vec v) {
        this.x -= v.x;
        this.y -= v.y;
        this.z -= v.z;
        return this;
    }
    public Vec subNew(Vec v) {
        float x = this.x - v.x;
        float y = this.y - v.y;
        float z = this.z - v.z;
        return new Vec(x, y, z);
    }
    public Vec mean(Vec v) {
        return new Vec((this.x+v.x)/2f, (this.x+v.x)/2f, (this.z+v.z)/2f);
    }
    public Vec scale(float s) {
        this.x *= s;
        this.y *= s;
        this.z *= s;
        return this;
    }
    public Vec between(Vec v, float s) {
        float t_x = (1-s)*v.x + s*v.x;
        float t_y = (1-s)*v.y + s*v.y;
        float t_z = (1-s)*v.z + s*v.z;
        return new Vec(t_x, t_y, t_z);
    }
    public Vec nor() {
        float len = this.mag();
        this.x /= len;
        this.y /=len;
        this.z /= len;
        return this;
    }
    public Vec norNew() {
        float len = this.mag();
        float x = this.x / len;
        float y = this.y /len;
        float z = this.z / len;
        return new Vec(x, y, z);
    }
    public float dot(Vec v) {
        return this.x*v.x + this.y*v.y + this.z*v.z;
    }
    public Vec cross(Vec v) {
        float x = this.y*v.z - this.z*v.y;
        float y = this.x*v.z - this.z*v.x;
        float z = this.x*v.y - this.y*v.x;
        return new Vec(x, y, z);
    }
    public float angle(Vec v) {
        float dotPQ = this.dot(v);
        float mag_p = this.mag();
        float mag_q = v.mag();
        float cosAngle = dotPQ/(mag_p*mag_q);
        return (float) Math.acos(cosAngle);
    }
    public float mag() {
        float distSQ = this.x*this.x + this.y*this.y + this.z*this.z;
        return (float) Math.sqrt(distSQ);
    }
    public float distance(Vec v) {
        float dx = this.x - v.x;
        float dy = this.y - v.y;
        float dz = this.z - v.z;
        return (float) Math.sqrt(dx*dx + dy*dy + dz*dz);
    }
    public float _toRadian(float angle) {
        return (float) (angle*Math.PI/180.);
    }
    public float _toAngle(float radian) {
        return (float) (radian*180/Math.PI);
    }
    public void printInfo() {
        System.out.println(x+" "+y+" "+z);
    }

    public void set(Vec dir) {
        this.x = dir.x;
        this.y = dir.y;
        this.z = dir.z;
    }

    public void set(float x, float y) {
        this.x = x;
        this.y = y;
        this.z = 0;
    }

    public Vec scaleNew(float v) {
        return new Vec(this.x*v, this.y*v, this.z*v);
    }

    public void drawVec(PApplet app, Vec loc, int length) {
        Vec nor = this.norNew();
        nor.scale(length);
        Vec ep = loc.addNew(nor);

        app.line(loc.x, loc.y, ep.x, ep.y);
    }

    public Vec l_rotate(){
        Vec k = new Vec(-this.y,this.x);
        return k;
    }
    public float distance2D(Vec v) {
        float dx = this.x - v.x;
        float dy = this.y - v.y;
        return (float) Math.sqrt(dx*dx + dy*dy);
    }

    public Vec copy(){
        return new Vec(this.x,this.y);
    }
}
