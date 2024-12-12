package mk.ukim.finki.wp.lab.web;

import mk.ukim.finki.wp.lab.model.Event;
import mk.ukim.finki.wp.lab.model.Location;
import mk.ukim.finki.wp.lab.service.EventService;
import mk.ukim.finki.wp.lab.service.LocationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class EventController {

    private final EventService eventService;
    private final LocationService locationService;
    public EventController(EventService eventService, LocationService locationService) {
        this.eventService = eventService;
        this.locationService = locationService;
    }

//    @GetMapping("/events")
//    public String getEventsPage(@RequestParam(required = false) String error, Model model) {
//        if (error != null) {
//            model.addAttribute("error", error);
//        }
//        model.addAttribute("events", eventService.listAll());
//        return "listEvents";
//    }

    @GetMapping("/events")
    public String searchEvents(@RequestParam(required = false) String searchText,
                               @RequestParam(required = false) Double minRating,
                               Model model) {
        List<Event> events = eventService.listAll();  // Преземете ги сите настани

        if (searchText != null && !searchText.isEmpty()) {
            events = events.stream()
                    .filter(event -> event.getName().contains(searchText) || event.getDescription().contains(searchText))
                    .collect(Collectors.toList());
        }

        if (minRating != null) {
            events = events.stream()
                    .filter(event -> event.getPopularityScore() >= minRating)
                    .collect(Collectors.toList());
        }

        model.addAttribute("events", events);
        return "listEvents";  // Патека до страницата која ќе ги прикаже настаните
    }

    @GetMapping("/events/add")
    public String getAddEventPage(Model model) {
        model.addAttribute("locations", locationService.findAll());
        return "add_editForm";
    }

    @GetMapping("/events/edit/{id}")
    public String getEditEventPage(@PathVariable Long id, Model model) throws Exception {
        System.out.println(id);
        Event event = eventService.findById(id);

        model.addAttribute("event", event);  // Додадете го event во моделот
        model.addAttribute("locations", locationService.findAll());  // Додадете ги локациите
        return "add_editForm";  // Вратете ја формата за уредување
    }

    @PostMapping("/events/add")
    public String addEvent(@RequestParam(name = "name") String name,
                           @RequestParam(name = "description") String description,
                           @RequestParam(name = "popularityScore") Double popularityScore,
                           @RequestParam(name = "locationId") Long locationId) throws Exception {
        eventService.addEvent(name, description, popularityScore, locationId);
        return "redirect:/events";
    }

    @PostMapping("/events/edit/{id}")
    public String editEvent(@PathVariable Long id,
                            @RequestParam String name,
                            @RequestParam String description,
                            @RequestParam Double popularityScore,
                            @RequestParam Long locationId) throws Exception {
        // Повикај ја editChanges методата од сервисот
        eventService.editChanges(id, name, description, popularityScore, locationId);

        return "redirect:/events";  // Враќање на страницата со настани
    }

    @GetMapping("/deleteEvent/{eventId}")
    public String deleteEvent(@PathVariable Long eventId) {
        eventService.deleteEvent(eventId);
        return "redirect:/events";
    }

    @PostMapping("/eventBooking")
    public String bookEvent(@RequestParam String eventName,
                            @RequestParam int numTickets,
                            Model model) {
        // Овде ги поставувате атрибутите во моделот
        model.addAttribute("eventName", eventName);
        model.addAttribute("numTickets", numTickets);

        // Пренасочување на страницата за потврда
        return "bookingConfirmation";  // Патот до страницата за потврда на резервацијата
    }

}
