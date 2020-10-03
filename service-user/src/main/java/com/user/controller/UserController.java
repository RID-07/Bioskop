/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.user.controller;

import com.user.entity.film.Hadiah;
import com.user.repository.film.HadiahRepository;
import com.user.service.film.FilmService;
import com.user.view.ViewResponse;
import com.user.view.ViewTicket;
import com.user.view.ViewTotalPoint;
import com.user.view.ViewTukarHadiah;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ridho
 */
@Api(tags = "Service Bioskop", description = "Rest Service Get Ticket", produces = "application/json")
@ApiResponses(value = {
    @ApiResponse(code = 200, message = "Success")
    ,
    @ApiResponse(code = 400, message = "Failed")
})
@RestController
@RequestMapping("/rest/service")
public class UserController {

    @Autowired
    FilmService filmService;
    @Autowired
    HadiahRepository hadiahRepository;

    @ApiOperation(value = "Get Ticket")
    @GetMapping(value = "/getTicket/{kdTicket}", produces = "application/json")
    public ViewTicket getTicket(@PathVariable("kdTicket") String kdTicket) {
        return filmService.selectViewKarcis(kdTicket);
    }
    
    @ApiOperation(value = "Get Hadiah")
    @GetMapping(value = "/hadiah", produces = "application/json")
    public List<Hadiah> getAllHadiah() {
        return hadiahRepository.findAll();
    }
    
    @ApiOperation(value = "Post Tukar Hadiah")
    @PostMapping(value = "/tukarhadiah", produces = "application/json", consumes = "application/json")
    public ViewResponse tukarHadiah(@RequestBody ViewTukarHadiah tukarHadiah) {
       return filmService.tukarHadiah(tukarHadiah);
    }
    
    @ApiOperation(value = "Get Total Point")
    @GetMapping(value = "/point/{email}", produces = "application/json")
    public ViewTotalPoint getTotalPoint(@PathVariable("email") String email) {
        return filmService.totalPoint(email);
    }
}
