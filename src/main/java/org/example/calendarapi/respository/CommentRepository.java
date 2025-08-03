package org.example.calendarapi.respository;

import org.example.calendarapi.entity.Comment;
import org.example.calendarapi.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findBySchedule(Schedule schedule);
}
