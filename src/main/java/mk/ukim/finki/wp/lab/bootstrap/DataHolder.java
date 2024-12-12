package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import mk.ukim.finki.wp.lab.model.Event;
import mk.ukim.finki.wp.lab.model.Location;
import mk.ukim.finki.wp.lab.repository.EventRepository;
import mk.ukim.finki.wp.lab.repository.LocationRepository;
import org.springframework.stereotype.Component;

@Component
@Getter
public class DataHolder {

    private final EventRepository eventRepository;
    private final LocationRepository locationRepository;

    public DataHolder(EventRepository eventRepository, LocationRepository locationRepository) {
        this.eventRepository = eventRepository;
        this.locationRepository = locationRepository;
    }


    @PostConstruct
    public void init()
    {

//        for (int i=0; i<5; i++)
//        {
//            Event events = (new Event("Name"+i, "Description"+1, i));
//            eventRepository.save(events);
//        }

//
        Location location1 = new Location("Tech Hub", "123 Tech Street, Silicon Valley", "1000", "A cutting-edge venue for tech events.");
        Location location2 = new Location("Art Gallery", "45 Art Road, City Centre", "500", "A modern gallery showcasing contemporary art.");
        Location location3 = new Location("Science Park", "789 Innovation Blvd, Science City", "800", "A park dedicated to science and technology exhibitions.");
        Location location4 = new Location("Food Plaza", "100 Tasty Lane, Foodie Town", "2000", "A vibrant plaza hosting food festivals and culinary events.");
        Location location5 = new Location("Fashion Arena", "15 Fashion Avenue, Style District", "1500", "A chic venue for the latest fashion shows.");
        Location location6 = new Location("Theatre Royale", "22 Stage Street, Arts District", "600", "A historic theatre hosting dramatic performances.");
        Location location7 = new Location("Rock Arena", "58 Rock Street, Music City", "1200", "A large venue for live music performances.");
        Location location8 = new Location("Cinema Palace", "33 Movie Way, Entertainment Park", "400", "A state-of-the-art cinema for movie nights.");
        Location location9 = new Location("Gala Hall", "70 Charity Boulevard, Philanthropy District", "500", "An elegant hall for high-profile charity galas.");

        locationRepository.save(location1);
        locationRepository.save(location2);
        locationRepository.save(location3);
        locationRepository.save(location4);
        locationRepository.save(location5);
        locationRepository.save(location6);
        locationRepository.save(location7);
        locationRepository.save(location8);
        locationRepository.save(location9);

        Event events1 = new Event("Tech Conference 2024", "A gathering of technology enthusiasts and innovators", 4.8, location1);
        Event events2 = new Event("Art Exhibition", "An exhibition showcasing contemporary art", 4.5, location2);
        Event events3 = new Event("Science Fair", "Students present innovative scientific projects", 4.6, location3);
        Event events4 = new Event("Food Festival", "A celebration of world cuisines and food culture", 4.4, location4);
        Event events5 = new Event("Fashion Show", "Top designers reveal their latest collections", 4.6, location5);
        Event events6 = new Event("Theatre Play", "A dramatic performance of a famous Shakespearean play", 4.8, location6);
        Event events7 = new Event("Rock Band Live", "A live performance by a famous rock band", 4.9, location7);
        Event events8 = new Event("Movie Night", "A screening of a classic action movie", 4.2, location8);
        Event events9 = new Event("Charity Gala", "A high-profile event raising funds for a noble cause", 4.5, location9);


        eventRepository.save(events1);
        eventRepository.save(events2);
        eventRepository.save(events3);
        eventRepository.save(events4);
        eventRepository.save(events5);
        eventRepository.save(events6);
        eventRepository.save(events7);
        eventRepository.save(events8);
        eventRepository.save(events9);

        //
    }
}
