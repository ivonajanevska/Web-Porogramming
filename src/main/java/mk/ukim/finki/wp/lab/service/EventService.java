package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Event;

import java.util.List;

public interface EventService {

    List<Event> listAll();
    List<Event> searchEvents(String text);

    List<Event> searchEventsWithRating(String text, String text2, double rating);

    List<Event> filterByRating(double rating);

    void deleteEvent(Long eventId);

    Event findById(Long eventId) throws Exception;

    void editEvent (Long eventId, Event event);

    void addEvent(String name, String description, double popularityScore, Long locationId) throws Exception;

    public void editChanges(Long id, String name, String descr, Double rating, Long locId) throws Exception;

}
