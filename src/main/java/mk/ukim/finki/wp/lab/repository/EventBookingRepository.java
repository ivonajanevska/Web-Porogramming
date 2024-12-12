package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.EventBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventBookingRepository extends JpaRepository<EventBooking, Long> {


}
