package ComplexJson;

import com.beust.ah.A;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Validations1 {
    public static JsonPath jsp;

    public static void main(String[] args) {
        jsp = new JsonPath(Payload.complexCase1());
        int purchaseAmount = jsp.getInt("dashboard.purchaseAmount");
        System.out.println(purchaseAmount);
        int courseSize = jsp.getInt("courses.size()");
        System.out.println(courseSize);

        for (int i = 0; i < courseSize; i++) {
            String title = jsp.get("courses[" + i + "].title");
            System.out.println(title);
        }
        List<String> toatl_titles = jsp.getList("courses.title");
        for (String title : toatl_titles) {
            if (title.equalsIgnoreCase("RPA")) {
                System.out.println("presented ");
                break;
            }

        }

        for (int i = 0; i < courseSize; i++) {
            String altitle = jsp.get("courses[" + i + "].title");
            if (altitle.equalsIgnoreCase("RPA")) {

                System.out.println(jsp.getString("courses[" + i + "].price"));
            }
        }
        String totalpurchaseAmount = jsp.getString("purchaseAmount");

        List<Integer> prices = new ArrayList<>();
        List<Integer> copys = new ArrayList<>();

        for (int i = 0; i < courseSize; i++) {
            int price = jsp.getInt("courses[" + i + "].price");
            prices.add(price);
            int copy = jsp.getInt("courses[" + i + "].copies");
            copys.add(copy);

        }
       int total_Price= IntStream.range(0,courseSize).map(i-> copys.get(i)*prices.get(i)).sum();
        System.out.println(total_Price);
        Assert.assertEquals(totalpurchaseAmount,total_Price);




    }
}
