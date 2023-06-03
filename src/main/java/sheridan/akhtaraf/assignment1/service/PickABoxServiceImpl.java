package sheridan.akhtaraf.assignment1.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class PickABoxServiceImpl implements PickABoxService {

    List<String> gifts = new ArrayList<String>();

    private PickABoxServiceImpl() {
        gifts.add("Iphone");
        gifts.add("Better Luck Next Time!");
        gifts.add("Watch");
    }
    @Override
    public PickABoxData getBoxes(int numberOfBoxes) {
        if (gifts == null || gifts.size() < numberOfBoxes || numberOfBoxes <= 0) {
            return new PickABoxDataImpl(gifts);
        }

        Random random = new Random();
        List<String> selectedStrings = new ArrayList<>(numberOfBoxes);


        for (int i = 0; i < numberOfBoxes; i++) {
            int randomIndex = random.nextInt(gifts.size());
            selectedStrings.add(gifts.get(randomIndex));
        }

        return new PickABoxDataImpl(selectedStrings);
    }

}
