package com.example.gicworkshop.day7.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "student_course")
public class StudentCourse {

    @EmbeddedId
    private StudentCourseId id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    private Course course;

    public StudentCourse() {}

    public StudentCourse(Student student, Course course) {
        this.student = student;
        this.course = course;
        this.id = new StudentCourseId(student.getId(), course.getId());
    }

    // getters and setters
    public StudentCourseId getId() { return id; }
    public void setId(StudentCourseId id) { this.id = id; }
    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }
    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }
}
