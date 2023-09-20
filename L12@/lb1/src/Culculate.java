public class Culculate {
    private int sunDiameter = 1391980;//км
    private int earthDiameter = 12756;

    public Culculate() {
    }
    public int getSunDiameter() {
        return sunDiameter;
    }

    public void setSunDiameter(int sunDiameter) {
        this.sunDiameter = sunDiameter;
    }

    public int getEarthDiameter() {
        return earthDiameter;
    }

    public void setEarthDiameter(int earthDiameter) {
        this.earthDiameter = earthDiameter;
    }
    public Double V(int diameter){
        return 4*Math.PI*Math.pow(diameter/2,3)/3;
    }
}
