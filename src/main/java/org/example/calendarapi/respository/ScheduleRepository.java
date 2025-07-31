package org.example.calendarapi.respository;

import org.example.calendarapi.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ScheduleRepository extends JpaRepository<Schedule,Long> {
    Optional<List<Schedule>> findByWriter(String writer);
}
