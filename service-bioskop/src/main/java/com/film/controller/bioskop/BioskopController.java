/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.film.controller.bioskop;

import com.film.entity.bioskop.DataFilm;
import com.film.entity.bioskop.Hadiah;
import com.film.entity.bioskop.Studio;
import com.film.repository.bioskop.TiketRepository;
import com.film.service.bioskop.BioskopService;
import com.film.view.ViewFilm;
import com.film.view.ViewHadiah;
import com.film.view.ViewKarcis;
import com.film.view.ViewResponse;
import com.film.view.ViewStudio;
import com.film.view.ViewTiket;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ridho
 */
@Api(tags = "Service Bioskop", description = "REST Service Bioskop", produces = "application/json")
@ApiResponses(value = {
    @ApiResponse(code = 200, message = "Success")
    ,
    @ApiResponse(code = 400, message = "Failed")
})
@RestController
@RequestMapping("/bioskop/xxi")
public class BioskopController {

    @Autowired
    BioskopService bioskopService;
    @Autowired
    TiketRepository tiketRepository;

    @ApiOperation(value = "Post Ticket", notes = "KODE_FILM :"
            + " F11(SUPERMAN),"
            + " F22(SPIDERMAN),"
            + " F33(BLACK PHANTER),"
            + " F44(IRON MAN),"
            + " F55(HULK)"
            + " |CONTOH INPUT KODE TIKET(AA11, AA22, AA33 DST)")
    @PostMapping(value = "/postTicket", produces = "application/json", consumes = "application/json")
    public ViewResponse postTicket(@RequestBody ViewTiket viewTiket) {
        return bioskopService.postResponse(viewTiket);
    }

    @ApiOperation(value = "Post Film", notes = "KODE_FILM(EX: F11,F22,F33....DST)")
    @PostMapping(value = "/postFilm", produces = "application/json", consumes = "application/json")
    public DataFilm postFilm(@RequestBody ViewFilm viewFilm) {
        return bioskopService.saveDataFilm(viewFilm);
    }

    @ApiOperation(value = "Post Studio", notes = "KODE_STUDIO(EX: 01A, 01B, 01C....DST)")
    @PostMapping(value = "/postStudio", produces = "application/json", consumes = "application/json")
    public Studio postStudio(@RequestBody ViewStudio viewStudio) {
        return bioskopService.saveStudio(viewStudio);
    }
    
        
    @ApiOperation(value = "Post Hadiah")
    @PostMapping(value = "/postHadiah", produces = "application/json", consumes = "application/json")
    public void postHadiah(@RequestBody ViewHadiah viewHadiah) {
        bioskopService.saveHadiah(viewHadiah);
    }
    

    @ApiOperation(value = "Put Ticket")
    @PutMapping(value = "/putTicket/{kdTicket}", produces = "application/json", consumes = "application/json")
    public ViewResponse putTicket(@RequestBody ViewTiket viewTiket, @PathVariable("kdTicket") String kdTicket) {
        return bioskopService.putResponse(viewTiket, kdTicket);
    }

    @ApiOperation(value = "Delete Ticket")
    @DeleteMapping(value = "/deleteTicket/{kdTicket}", produces = "application/json")
    public void deleteTicket(@PathVariable("kdTicket") String kdTicket) {
        tiketRepository.deleteByKdTicket(kdTicket);
    }

    @ApiOperation(value = "Get Ticket")
    @GetMapping(value = "/getTicket/{kdTicket}", produces = "application/json")
    public ViewKarcis getTicket(@PathVariable("kdTicket") String kdTicket) {
        return bioskopService.selectViewKarcis(kdTicket);
    }

    @ApiOperation(value = "Get Film")
    @GetMapping(value = "/getFilm/{kdFilm}", produces = "application/json")
    public ViewFilm getFilm(@PathVariable("kdFilm") String kdFilm) {
        return bioskopService.selectViewFilm(kdFilm);
    }

    @ApiOperation(value = "Get Studio")
    @GetMapping(value = "/getStudio/{kdStudio}", produces = "application/json")
    public ViewStudio getStudio(@PathVariable("kdStudio") String kdStudio) {
        return bioskopService.selectViewStudio(kdStudio);
    }
}
