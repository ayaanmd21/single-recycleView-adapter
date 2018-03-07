package faizzy.singlerecycleradapter;

/**
 * Created by Faizan on 7/3/18.
 */

public class Item {

    private String name;
    private String btnText;

    public Item(String name, String btnText) {
        this.name = name;
        this.btnText = btnText;
    }

    public String getName() {
        return name;
    }

    public String getBtnText() {
        return btnText;
    }
}
