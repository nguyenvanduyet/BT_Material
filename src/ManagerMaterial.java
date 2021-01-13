import storage.WriteAndRead;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class ManagerMaterial {
    ArrayList<Material> materialList = new ArrayList<>();
    public static final String PATH_NAME = "material.dat";

    public void inputMaterial(Material material) {
        materialList.add(material);
    }

    public void displayAll() {
        for (Material m : materialList) {
            System.out.println(m);
        }
    }

    public void sortByPriceOfMaterial() {
        Collections.sort(materialList, (o1, o2) -> {
            if (o1.getPrice() > o2.getPrice()) return 1;
            else if (o1.getPrice() < o2.getPrice()) return -1;
            else return 0;
        });
        System.out.println(materialList + "\n");
    }

    public void testPriceMaxAndMinOfMaterial() {
        sortByPriceOfMaterial();
        System.out.println("sản phẩm có giá lớn nhất là : " + materialList.get(materialList.size() - 1));
        System.out.println("sản phẩm có giá nhỏ nhất là : " + materialList.get(0));
    }

    public void removeExpiredMaterial() {
        for (Material m : materialList) {
            if (m.getExpiryDate().isAfter(LocalDate.now())) {
                materialList.remove(m);
            }
            System.out.println(m);
        }
    }

    public void writeFile() {
        WriteAndRead.write(materialList, PATH_NAME);
    }

    public void readFile() {
        materialList = (ArrayList<Material>) WriteAndRead.read(PATH_NAME);
        displayAll();
    }
}
