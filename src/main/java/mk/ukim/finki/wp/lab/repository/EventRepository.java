package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findByNameContaining(String name);
    List<Event> findByNameContainingOrDescriptionContainingOrPopularityScoreGreaterThanEqual(String name, String description, double popularityScore);
    List<Event> findByPopularityScoreGreaterThanEqual(double popularityScore);

    List<Event> findAllByLocation_Id(Long locationId);
}
