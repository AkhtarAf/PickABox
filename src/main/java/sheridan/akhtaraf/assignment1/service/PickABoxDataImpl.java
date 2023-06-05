package sheridan.akhtaraf.assignment1.service;

import java.util.List;

public class PickABoxDataImpl implements  PickABoxData {

    List<String> boxData;
    int boxNumber;

    public  PickABoxDataImpl(List<String> boxData, int boxNumber) {
        this.boxData = boxData;
        this.boxNumber = boxNumber;
    }
    @Override
    public List<String> getBoxData() {
        return boxData;
    }

    @Override
    public String getGift() {
        return boxData.remove(boxNumber-1);
    }

    @Override
    public List<String> getOtherBoxData() {
        return boxData;
    }

    @Override
    public int getNumberOfBoxes() {
        return boxData.size();
    }
}
