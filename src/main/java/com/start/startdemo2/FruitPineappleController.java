package com.start.startdemo2;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FruitPineappleController {

    private FruitPineapple pineapple1;
    private FruitPineapple pineapple2;
    private FruitPineapple pineapple3;

    @GetMapping("/listcontroller")
    public ResponseEntity<List<FruitPineapple>> listobjworking(){
        pineapple1 = new FruitPineapple();
        pineapple2 = new FruitPineapple();
        pineapple3 = new FruitPineapple();

        pineapple1.setBrand("Pru");
        pineapple1.setWeight(255);
        pineapple1.setColor("gold");
        pineapple2.setBrand("Vroadh");
        pineapple2.setWeight(155);
        pineapple2.setColor("pink");
        pineapple3.setColor("brown");
        pineapple3.setBrand("Vroadh");
        pineapple3.setWeight(134);


        List<FruitPineapple> list = new ArrayList<FruitPineapple>();
        list.add(pineapple1);
        list.add(pineapple2);
        for(FruitPineapple model : list) {
            System.out.println(model.getBrand());
            System.out.println(model.getColor());
            System.out.println(model.getWeight());
        }
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println(list.lastIndexOf(pineapple2));
        System.out.println(list.set(0,pineapple3));
        System.out.println(list.remove(1));
        list.add(pineapple2);
        System.out.println("\n"+list.equals(list));
        System.out.println("\n"+list.hashCode());
        System.out.println(list.addAll(0,list));
        System.out.println("\n"+list.retainAll(list));

        //System.out.println(list.subList(0,2));
        //System.out.println(list.get(0));
         //toArray();
        //System.out.println(list.contains(155));
        //System.out.println(list.stream().toArray());
        return ResponseEntity.ok().body(list);
    }

}
