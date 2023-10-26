import java.util.Random;

public class Vector3D {
    private static final Random random = new Random();
    private final double x;
    private final double y;
    private final double z;

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3D() {
        this(random.nextInt(-10, 10),
                random.nextInt(-10, 10),
                random.nextInt(-10, 10));
    }

    @Override
    public String toString() {
        return String.format("(%.2f, %.2f, %.2f)%n", x, y, z);

    }

    public double dotProduct(Vector3D vector3D) {
        return x * vector3D.x + y * vector3D.y + z * vector3D.z;
    }

    public Vector3D crossProduct(Vector3D vector3D) {
        return new Vector3D(
                y * vector3D.z - z * vector3D.y,
                x * vector3D.z - z * vector3D.x,
                x * vector3D.y - y * vector3D.x
        );
    }
}
