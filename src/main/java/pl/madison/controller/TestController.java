package pl.madison.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.madison.dao.BlockOfFlatsDao;
import pl.madison.domain.BlockOfFlats;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    BlockOfFlatsDao blockDao;

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String show(){
        String block = "";

        for (BlockOfFlats blockOfFlats : blockDao.findAll()) {
            block = block + blockOfFlats;
        }

        return block;
    }

    @RequestMapping(value = "/evenNumbers")
    public String evenNumber(){

        List<BlockOfFlats> evenNumbers = new ArrayList<BlockOfFlats>();

        for (BlockOfFlats blockOfFlats : blockDao.findAll()) {
            if(blockOfFlats.getNumber()%2==0){
                evenNumbers.add(blockOfFlats);
            }
        }

        return "" + evenNumbers;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String update(@RequestParam("id") Long id, @RequestParam("number") int number,
                         @RequestParam("street") String street){

        BlockOfFlats blockTemp = blockDao.findOne(id);
        blockTemp.setStreet(street);
        blockTemp.setNumber(number);
        blockDao.save(blockTemp);

        return "Updating completed";
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public String update(@RequestParam("number") int number,
                         @RequestParam("street") String street){

        BlockOfFlats blockTemp = new BlockOfFlats();
        blockTemp.setStreet(street);
        blockTemp.setNumber(number);
        blockDao.save(blockTemp);

        return "Adding completed";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.PUT)
    public String update(@RequestParam("id") Long id){

        blockDao.delete(id);

        return "Deleting completed";
    }
}
