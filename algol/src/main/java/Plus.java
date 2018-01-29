import jdk.nashorn.internal.objects.annotations.Getter;

import java.awt.*;

public class Plus implements Comparable {
    private int size;
    private Point center;

    Plus(int size, Point center) {
        this.size = size;
        this.center = center;

    }

//    @Override
//    public int compareTo(Plus comparePl) {
//        int compareSize=((Plus)comparePl).getSize();
//        //return this.size-compareSize;
//        return  compareSize - this.size;
//
//    }


    public int getSize() {
        return size;
    }

    public int compareTo(Object comparePl) {
        int compareSize = ((Plus) comparePl).getSize();
        //return this.size-compareSize;
        return compareSize - this.size;
    }

    public Point getCenter() {
        return center;
    }
}
