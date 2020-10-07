package models;

import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParamProduct {

    private String name;
    private String groupButton;
    private String productButton;
    private Map<String, String> coupleButtons;

    public ParamProduct (String name, Map<String, String> coupleButtons){
        this.name = name;
        this.coupleButtons = coupleButtons;
    }


    public String getGroupButton(){
        return groupButton;
    }

    public String getProductButton(){
        return productButton;
    }

    public String getName() {
        return name;
    }

    public void setGroupButton(String groupButton){
        this.groupButton = groupButton;
    }

    public void setProductButton(String productButton){
        this.productButton = productButton;
    }

    public void setName(String name){
        this.name = name;
    }



    public Map<String, String> getCoupleButton() {
        return coupleButtons;
    }

    public List<String> getListName(List<ParamProduct> listProducts){
       List<String> listName = new ArrayList<>();
        for(ParamProduct p : listProducts) {
            listName.add(p.getName());

        }
        return listName;
    }
}
