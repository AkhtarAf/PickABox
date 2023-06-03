package sheridan.akhtaraf.assignment1.service;

import java.util.List;

public class PickABoxDataImpl implements  PickABoxData {

    List<String> boxData;

    public  PickABoxDataImpl(List<String> boxData) {

        this.boxData = boxData;
    }
    @Override
    public List<String> getBoxData() {
        return boxData;
    }

    @Override
    public int getNumberOfBoxes() {
        return boxData.size();
    }
}
