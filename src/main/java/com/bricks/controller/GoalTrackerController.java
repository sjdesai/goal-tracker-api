package com.bricks.controller;

import com.bricks.service.GoalTrackerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@Api(value = "GoalTrackerControllerAPI", produces = MediaType.APPLICATION_JSON_VALUE)
public class GoalTrackerController {
    private GoalTrackerService goalTrackerService;

    @RequestMapping(path = "/muscle-groups", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Integer> getMuscleGroup(){
//        ArrayList<String> res =  goalTrackerService.getMuscleGround();
//        if(res!=null && !res.isEmpty()){
            return new ResponseEntity<Integer>(2, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
    }

    @Autowired
    public void setWorkoutTrackerService(GoalTrackerService goalTrackerService){
        this.goalTrackerService = goalTrackerService;
    }

}
