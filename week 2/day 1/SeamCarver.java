import edu.princeton.cs.algs4.Picture;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import java.util.*;
//import java.lang.*;
import java.awt.Color;

/**
 * SeamCarver
 */
public class SeamCarver {

    Picture pic;
    public SeamCarver(Picture picture) {
        pic = picture;
    }

    public Picture picture() {
        return pic;
    }

    public int width() {
        return pic.width();

    }

    public int height() {
        return pic.height();
    }

     /**
     * Returns the red component in the range 0-255 in the default sRGB
     * space.
     * @return the red component.
     * @see #getRGB
     */
    private int getRed(int RGBValue) {
        return (RGBValue >> 16) & 0xFF;
    }

    /**
     * Returns the green component in the range 0-255 in the default sRGB
     * space.
     * @return the green component.
     * @see #getRGB
     */
    private int getGreen(int RGBValue) {
        return (RGBValue >> 8) & 0xFF;
    }

    /**
     * Returns the blue component in the range 0-255 in the default sRGB
     * space.
     * @return the blue component.
     * @see #getRGB
     */
    private int getBlue(int RGBValue) {
        return (RGBValue >> 0) & 0xFF;
    }

    private double energy(int x, int y){
        if (x == 0 || y == 0 || x == width() -1 || y == height() - 1 ) {
            return 1000;
        }

        double redHorizontalValue = Math.pow(getRed(pic.getRGB(x + 1, y)) - getRed(pic.getRGB(x - 1, y)), 2);

        double blueHorizontalValue = Math.pow(getBlue(pic.getRGB(x + 1, y)) - getBlue(pic.getRGB(x - 1, y)), 2);

        double greenHorizontalValue = Math.pow(getGreen(pic.getRGB(x + 1, y)) - getGreen(pic.getRGB(x - 1, y)), 2);

        double redVerticalValue = Math.pow(getRed(pic.getRGB(x, y + 1)) - getRed(pic.getRGB(x, y - 1)), 2);

        double blueVerticalValue = Math.pow(getBlue(pic.getRGB(x, y + 1)) - getBlue(pic.getRGB(x, y - 1)), 2);
        
        double greenVerticalValue = Math.pow(getGreen(pic.getRGB(x, y + 1)) - getGreen(pic.getRGB(x, y - 1)), 2);

        return Math.sqrt(redHorizontalValue + blueHorizontalValue + greenHorizontalValue + redVerticalValue
                + blueVerticalValue + greenVerticalValue);

    }


    public static void main(String[] args) {
        Picture obj = new Picture(args[0]);
        SeamCarver ref = new SeamCarver(obj);
        // ref.pic.show();
        // System.out.println(ref.height());
        // System.out.println(ref.width());
        for (int i = 0; i < ref.width(); i++) {
                for (int j = 0; j < ref.height(); j++) {
                        System.out.println(ref.energy(i, j));
                }
        }
    }
}