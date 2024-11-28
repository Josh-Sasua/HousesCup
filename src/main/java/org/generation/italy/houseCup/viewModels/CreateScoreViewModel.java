package org.generation.italy.houseCup.viewModels;

import java.util.List;

public class CreateScoreViewModel {
    private long courseId;
    private long teacherId;
    private long studentId;
    private int score;
    private String reason;
    private List<StudentSelectViewModel> studentOptions;

    public CreateScoreViewModel() {
    }

    public CreateScoreViewModel(long courseId, long teacherId, long studentId, int score, String reason, List<StudentSelectViewModel> studentOptions) {
        this.courseId = courseId;
        this.teacherId = teacherId;
        this.studentId = studentId;
        this.score = score;
        this.reason = reason;
        this.studentOptions = studentOptions;
    }

    public long getCourseId() {
        return courseId;
    }
    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public long getTeacherId() {
        return teacherId;
    }
    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public long getStudentId() {
        return studentId;
    }
    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }

    public String getReason() {
        return reason;
    }
    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<StudentSelectViewModel> getStudentOptions() {
        return studentOptions;
    }
    public void setStudentOptions(List<StudentSelectViewModel> studentOptions) {
        this.studentOptions = studentOptions;
    }
}
