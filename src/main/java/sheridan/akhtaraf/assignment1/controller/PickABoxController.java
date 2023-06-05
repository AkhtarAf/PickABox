package sheridan.akhtaraf.assignment1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sheridan.akhtaraf.assignment1.service.PickABoxData;
import sheridan.akhtaraf.assignment1.service.PickABoxService;

import java.time.LocalDate;


@Controller
public class PickABoxController {
    private final Logger log = LoggerFactory.getLogger(PickABoxController.class);

    private final PickABoxService pickABoxService;

    public PickABoxController(PickABoxService pickABoxService) {
        this.pickABoxService = pickABoxService;
    }

    @GetMapping(value = {"/", "/pickabox"})
    public ModelAndView pickABoxGame(
            @RequestParam(defaultValue = "3") int numberOfBoxes,
            @RequestParam(defaultValue = "false") boolean isBoxPicked,
            @RequestParam(defaultValue = "0") int boxNumber
    ){
        log.trace("App is started");
        log.debug("numberOfBoxes = " + numberOfBoxes);
        log.debug("isBoxPicked = " + isBoxPicked);

        if(isBoxPicked){
            log.debug("Box is picked.");
            PickABoxData pickABoxData;
            if(numberOfBoxes > 0 && numberOfBoxes <= 5){
                pickABoxData = pickABoxService.getBoxes(numberOfBoxes, boxNumber);
            }else{
                log.warn("the numberOfBoxes is out of the range " + numberOfBoxes);
                pickABoxData = pickABoxService.getBoxes(3, boxNumber);
            }
//            log.debug("pickABoxData = " + pickABoxData.getBoxData());

            return  new ModelAndView("GameResult", "pickABoxData", pickABoxData);
        }else{
            log.debug("Box is not Picked");
            return new ModelAndView("GameStart");
        }
    }

    @ModelAttribute("localDate")
    LocalDate getlLocalDate(){
        return LocalDate.now();
    }
}
