public class Tetrahedron {
    private final Vector3D v1;
    private final Vector3D v2;
    private final Vector3D v3;

    public Tetrahedron(Vector3D v1, Vector3D v2, Vector3D v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    public double volume(){
        return Math.abs((v1.crossProduct(v2)).dotProduct(v3)) / 6.;
    }

    @Override
    public String toString() {
        return "" + v1 + v2 + v3 + "volume = " + volume();
    }

    public static void main(String[] args){
        Vector3D v1 = new Vector3D();
        Vector3D v2 = new Vector3D();
        Vector3D v3 = new Vector3D();
        Tetrahedron tetrahedron = new Tetrahedron(v1, v2, v3);
        System.out.println(tetrahedron);
    }
}
