package models;

import java.util.List;

public class ParamEducation {

    private List<String> listSubject;
    private boolean isHeaderVisible;

    public ParamEducation(List<String> listSubject, boolean isHeaderVisible){
        this.listSubject = listSubject;
        this.isHeaderVisible = isHeaderVisible;
    }

    public boolean getIsHeaderVisible() {
        return isHeaderVisible;
    }

    public List<String> getListSubject() {
        return listSubject;
    }

}
