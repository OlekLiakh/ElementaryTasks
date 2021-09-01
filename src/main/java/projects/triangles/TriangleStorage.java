package projects.triangles;

import java.text.DecimalFormat;
import java.util.Set;
import java.util.TreeSet;

public class TriangleStorage {
    private Set<Triangle> storage = new TreeSet<>();

    public boolean addTriangle(Triangle triangle) {
        return storage.add(triangle);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("============= Triangles list: ===============\n");
        if (storage.isEmpty()) {
            stringBuilder.append("List is empty.");
        } else {
            int counter = 0;
            for (Triangle triangle : storage) {
                counter += 1;
                stringBuilder.append(counter)
                        .append(". ")
                        .append(triangleToStringByFormat(triangle))
                        .append("\n");
            }
        }
        return stringBuilder.toString();
    }

    protected String triangleToStringByFormat(Triangle triangle) {
        DecimalFormat formatter = new DecimalFormat("###.##");
        String formatDoubleToString = formatter.format(triangle.getArea());
        String output = String.format("[%s]: %s ñm", triangle.getName(), formatDoubleToString);
        return output;
    }
}