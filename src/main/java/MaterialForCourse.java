import java.util.Arrays;

public class MaterialForCourse {
    static int count = 1;
    private int id = count;
    //    @Column(name = "file_data")
    private byte[] fileData;
    //    @Id
    private String name;

    public MaterialForCourse() {
        count += 1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MaterialForCourse{" +
                "id=" + id +
                ", fileData=" + Arrays.toString(fileData) +
                ", name='" + name + '\'' +
                '}';
    }
}

