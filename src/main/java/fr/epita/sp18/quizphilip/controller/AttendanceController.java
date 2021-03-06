package fr.epita.sp18.quizphilip.controller;

import fr.epita.sp18.quizphilip.entity.Attendance;
import fr.epita.sp18.quizphilip.model.ApiResponse;
import fr.epita.sp18.quizphilip.model.AttendResponse;
import fr.epita.sp18.quizphilip.service.AttendanceService;
import fr.epita.sp18.quizphilip.model.AnswerRequest;
import fr.epita.sp18.quizphilip.model.AttendRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/attendances")
public class AttendanceController
{
    private final AttendanceService service;
    
    @Autowired
    public AttendanceController(AttendanceService service)
    {
        this.service = service;
    }
    
    @PostMapping()
    public ApiResponse<AttendResponse> create(@RequestBody AttendRequest request)
    {
        return service.attend(request);
    }
    
    @PutMapping("/{attendanceId}/answer/{questionId}")
    public Long update(@PathVariable Long attendanceId, @PathVariable Long questionId, @RequestBody AnswerRequest request)
    {
        return service.answer(attendanceId, questionId, request);
    }
}
