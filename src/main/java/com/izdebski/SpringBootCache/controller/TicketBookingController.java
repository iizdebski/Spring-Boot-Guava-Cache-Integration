package com.izdebski.SpringBootCache.controller;

import com.izdebski.SpringBootCache.entities.Ticket;
import com.izdebski.SpringBootCache.service.TicketBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/tickets")
public class TicketBookingController {

    @Autowired
    private TicketBookingService ticketBookingService;

    @GetMapping(value="/ticket/{ticketId}")
    public Ticket getTicketById(@PathVariable("ticketId")Integer ticketId){
        return ticketBookingService.getTicketById(ticketId);
    }

    @DeleteMapping(value="/ticket/{ticketId}")
    public void deleteTicket(@PathVariable("ticketId")Integer ticketId){
        ticketBookingService.deleteTicket(ticketId);
    }

    @PutMapping(value="/ticket/{ticketId}/{newEmail:.+}")
    public Ticket updateTicket(@PathVariable("ticketId")Integer ticketId,@PathVariable("newEmail")String newEmail){
        return ticketBookingService.updateTicket(ticketId,newEmail);
    }
}