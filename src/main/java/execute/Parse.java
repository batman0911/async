package execute;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

/**
 * Created by linhnm20 on Jul, 2020
 */

public class Parse {
    public static void main(String[] args) {
        Gson gson = new Gson();

        List<String> myList = Arrays.asList("Linh Nguyen", "Mai Tran", "Chan Nguyen");

        System.out.println("list in java: " + myList);

        String myJson = gson.toJson(myList);

        System.out.println("json list: " + myJson);
    }
}
