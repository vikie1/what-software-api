package io.github.vikie1.whatsoftware.controller.api;

import io.github.vikie1.whatsoftware.entity.SoftwareOfTheDayEntity;
import io.github.vikie1.whatsoftware.service.SoftwareOfTheDayService;
import io.github.vikie1.whatsoftware.util.DayOfTheWeek;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;

@RestController @RequestMapping("/api")
public class GetRequestsController {

    @Autowired
    SoftwareOfTheDayService softwareOfTheDayService;

    //Requests for software of the day
    @GetMapping("/SotD")
    public SoftwareOfTheDayEntity getSoftwareOfTheDay(HttpServletRequest request, HttpServletResponse response){
        int day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        if (day == Calendar.SUNDAY) {
            try { response.sendRedirect(request.getContextPath() + "/api/SotD"); }
            catch (IOException e) { e.printStackTrace(); }
        }
        return softwareOfTheDayService.getSoftwareOfTheDayByDate(DayOfTheWeek.getDayById(day));
    }
    @GetMapping("/SotD/day/{day}")
    public SoftwareOfTheDayEntity getSoftwareOfTheDayByDay(@PathVariable String day, HttpServletRequest request, HttpServletResponse response){
        if (DayOfTheWeek.getIdByDay(day) == Calendar.SUNDAY) {
            try { response.sendRedirect(request.getContextPath() + "/api/SotW"); }
            catch (IOException e) { e.printStackTrace(); }
        }
        return softwareOfTheDayService.getSoftwareOfTheDayByDate(day);
    }
    @GetMapping("/SotD/software/{software}")
    public SoftwareOfTheDayEntity getSoftwareOfTheDayBySoftware(@PathVariable String software){
        return softwareOfTheDayService.getSoftwareOfTheDayByName(software);
    }
    @GetMapping("/SotW")
    public HashMap<String, SoftwareOfTheDayEntity> getStarsOfTheWeek(HttpServletRequest request, HttpServletResponse response){
        int day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        if (day != Calendar.SUNDAY) {
            try { response.sendRedirect(request.getContextPath() + "/api/SotD"); }
            catch (IOException e) { e.printStackTrace(); }
        }
        return softwareOfTheDayService.getWeeklySoftware();
    }

}
