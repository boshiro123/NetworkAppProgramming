public class Calculate {
    private int sunDiameter = 1_391_980;//км
    private int earthDiameter = 12_756;

    private int sunDiameterMili = 864_000;//мили
    private int earthDiameterMili = 7_926;

    public Calculate() {
    }
    public Double Volume(int diameter){
        return 4*Math.PI*Math.pow(diameter/2,3)/3;
    }
    public Double Ratio(int diameter1, int diameter2){
        return Volume(diameter1)/Volume(diameter2);
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

    public int getSunDiameterMili() {
        return sunDiameterMili;
    }

    public void setSunDiameterMili(int sunDiameterMili) {
        this.sunDiameterMili = sunDiameterMili;
    }

    public int getEarthDiameterMili() {
        return earthDiameterMili;
    }

    public void setEarthDiameterMili(int earthDiameterMili) {
        this.earthDiameterMili = earthDiameterMili;
    }

}
