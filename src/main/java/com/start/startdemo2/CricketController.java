package com.start.startdemo2;

import net.bytebuddy.implementation.bind.annotation.Default;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
public class CricketController {

    @Autowired
    DashboardRepo dashboardrepo;

    @GetMapping("/showdetails")
    public ResponseEntity<List<Dashboard>> getdetails(){

        List<Dashboard> list= dashboardrepo.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/allruns/byyear")
    public ResponseEntity getdetailsyear(@RequestParam  int year, @RequestParam(required=true,defaultValue=" ") String format ){
        int totalruns=0;
        List<Dashboard> list= dashboardrepo.findByyearformat(year,format);
        if(year>=2011) {
            if (format.contentEquals("T-20") || format.equalsIgnoreCase("Oneday") || format.contentEquals("Test")) {

                for (Dashboard dd : list) {
                    totalruns = totalruns + dd.getPlayerRuns();
                }
            } else if (format.isBlank() || format.isEmpty()) {
                return ResponseEntity.ok().body("please enter format");
            } else {
                return ResponseEntity.ok().body("format not supported");
            }
        }
        else
        {
            return ResponseEntity.ok().body("year Should be greater than 2011");
        }
            return ResponseEntity.ok().body("total runs in year: " + year + " are " + totalruns + "in" + format);

        }


    @GetMapping("/allruns/bycountry/byyear")
    public ResponseEntity<List<Dashboard>> getdetailscountryyear(@RequestParam("year") int year,@RequestParam("country") String country){

        List<Dashboard> list= dashboardrepo.findByyearcountry(year,country);

        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/T-20/allruns/byplayer")
    public ResponseEntity getdetailsbyplayer(@RequestParam("player") String player){

        List<Dashboard> list= dashboardrepo.findByyearbyplayer(player);
        int totalruns=0;
        for(Dashboard dd : list){
            totalruns=dd.getPlayerRuns();
        }

        return ResponseEntity.ok().body("totalruns by"+player+"is"+totalruns);
    }


    @GetMapping("/noofplayers/year")
    public ResponseEntity getdetailsbyyear(@RequestParam("year") int year){

        List<Dashboard> list= dashboardrepo.findByyear(year);
        int totalplayers=0;

        if(year>=2011) {
            totalplayers = list.size();
        }
        else if(year<=2010 && year>=1){
            return ResponseEntity.ok().body("please year above 2011");
        }
        else{

            List<Dashboard> list1= dashboardrepo.findAll();

            totalplayers= list1.size();
        }

        return ResponseEntity.ok().body("total players"+totalplayers);
    }
}
