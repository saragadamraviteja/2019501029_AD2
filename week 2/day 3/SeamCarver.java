import edu.princeton.cs.algs4.Picture;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
// import java.util.*;
/**
 * SeamCarver
 */
public class SeamCarver {

    private Picture pic;
    public SeamCarver(Picture picture) {
        if (picture == null) {
            throw new IllegalArgumentException();
        }
        pic = new Picture(picture);
    }

    public Picture picture() {
        return new Picture(pic);
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

    private double[][] arr;

    public int[] findVerticalSeam() {
        if (this.height() == 1 && this.width() == 1) {
            int[] tempy = new int[]{0};
            return tempy;
        }
        if (this.width() == 1) {
            int[] temp2 = new int[this.height()];
            return temp2;
        }
    arr = new double [pic.height()][pic.width()];
        for (int i = 0; i < pic.height(); i++) {
            for (int j = 0; j < pic.width(); j++) {
                    arr[i][j] = energy(j, i);
            }
        }
        // for (int l = 0; l < arr.length; l++) {
        //     System.out.println(Arrays.toString(arr[l]));
        //     }
    //System.out.println(Arrays.toString(modify()));
    return modify();
}

    private int[] modify() {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == 1) {
                arr[i][j] = 1000 + arr[i][j];
                }  else {
                        if (j == 0) {
                            if (arr[i - 1][j] < arr[i - 1][j + 1]) {
                                    arr[i][j] += arr[i - 1][j]; 
                            } else {
                                arr[i][j] += arr[i - 1][j + 1];
                            }
                        } else if (j == arr[i].length - 1) {
                            if (arr[i - 1][j] < arr[i - 1][j - 1]) {
                                arr[i][j] += arr[i - 1][j];
                            } else {
                                arr[i][j] += arr[i - 1][j - 1];
                            }
                        } else {
                            if (arr[i - 1][j - 1] < arr[i - 1][j]) {
                                    if (arr[i - 1][j - 1] < arr[i - 1][j + 1]) {
                                        arr[i][j] += arr[i - 1][j - 1]; 
                                    } else {
                                        arr[i][j] += arr[i - 1][j + 1];
                                    }
                            } else {
                                if (arr[i - 1][j] < arr[i - 1][j + 1]) {
                                        arr[i][j] += arr[i - 1][j];
                                } else {
                                    arr[i][j] += arr[i - 1][j + 1];
                                }
                            }
                        }
                }
            }
        }
        // for (int l = 0; l < arr.length; l++) {
        // System.out.println(Arrays.toString(arr[l]));
        // }
        double min = 0.0;
        int k = 0;
        int[] colm = new int[arr.length];
        int temp = 0;
        for (int i = 0; i < arr[0].length- 1; i++) {
            if (arr[arr.length - 1][i] > arr[arr.length - 1][i + 1]) {
                    min = arr[arr.length - 1][i + 1];
                    temp = i + 1;
                    //System.out.println(temp);
                }
        }
        colm[arr.length - 1]= temp;
        //System.out.println(colm[arr.length - 1]);
        //System.out.println(min);
        //System.out.println("temp" +temp);
        //System.out.println(pic.height() - 2);
        for (int i = arr.length - 1; i > 0; i--) {
            //System.out.println(i);
            //System.out.println("a" +" " + colm[arr.length - 1]);
            if (temp == 0) {
                if (arr[i - 1][temp] <arr[i - 1][temp + 1] ) {
                        colm[i - 1] = temp; 
                       // System.out.println("b" +" " + colm[arr.length - 1]);
                } else {
                    colm[i - 1] = temp + 1 ;
                    temp += 1;
                   // System.out.println("c" +" " + colm[arr.length - 1]);
                }
            } else if (temp == arr[i].length - 1) {
                //System.out.println("d" +" " + colm[arr.length - 1]);
                if (arr[i - 1][temp] < arr[i - 1][temp -1]) {
                    //System.out.println("e" +" " + colm[arr.length - 1]);
                    colm[i -1] = temp; 
                } else {
                    //System.out.println("f" +" " + colm[arr.length - 1]);
                    colm[i - 1] = temp - 1;
                    temp = temp - 1;
                }
            } else {
              // System.out.println(temp + " "+ i+" "+ pic.width());
               //System.out.println(arr[i - 1][temp + 1]+ "****");
                if (arr[i - 1][temp - 1] < arr[i - 1][temp]) {
                    //System.out.println("g" +" " + colm[arr.length - 1]);
                    //System.out.println(arr[i - 1][temp + 1]);
                    if (arr[i - 1][temp - 1] < arr[i - 1][temp + 1]) {
                        //System.out.println("h" +" " + colm[arr.length - 1]);
                       // System.out.println(arr[i - 1][temp+1]);
                        colm[i - 1] = temp - 1;
                        temp -= 1;
                    } else {
                            colm[i -1] = temp + 1;
                            temp += 1;
                            //System.out.println("i" +" " + colm[arr.length - 1]);
                        }
                    } else {
                        if (arr[i - 1][temp] < arr[i - 1][temp + 1]) {
                            //System.out.println("j" +" " + colm[arr.length - 1]);
                            colm[i -1] = temp;
                        } else {
                            colm[i -1] = temp + 1;
                            temp += 1;
                            //System.out.println("k" +" " + colm[arr.length - 1]);
                        }
                    }
                }
            }
            if (colm.length == 1){
                return colm;
            }
            if(colm[1] == 0){
                colm[0] = 0;
            }else{
                colm[0] = colm[1]-1;
            }
            return colm;
        }
    

    private void matrixTranspose() {
        double[][] arrNew = new double[pic.width()][pic.height()]; 
        for (int i = 0; i < pic.width(); i++) {
            for (int j = 0; j < pic.height(); j++) {
                arrNew[i][j] = arr[j][i];
            }
        }
        arr = arrNew;
        // System.out.println(Arrays.toString(modify()));
        // for (int l = 0; l < arrNew.length; l++) {
        //     System.out.println(Arrays.toString(arrNew[l]));
        // }
    }

    public int[] findHorizontalSeam() {
        if (this.height() == 1 && this.width() == 1) {
            int[] tempy = new int[]{0};
            return tempy;
        }
        if (this.height() == 1) {
            int[] temp1 = new int[this.width()];
            return temp1;
        }
        arr = new double [pic.height()][pic.width()];
        // arrNew = new double[pic.width()][pic.height()]; 
        for (int i = 0; i < pic.height(); i++) {
            for (int j = 0; j < pic.width(); j++) {
                arr[i][j] = energy(j, i);
            }
        }
        matrixTranspose();
            //modify();
            // arr = arrNew;
        return modify();
    }

        

    public double energy(int x, int y){
        if (x < 0 || x > this.width() - 1 || y < 0 || y > this.height() - 1) {
            throw new IllegalArgumentException();
        }
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
        ref.findVerticalSeam();
        ref.findHorizontalSeam();
    }
}