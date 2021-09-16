package io.github.vikie1.whatsoftware.controller.api;

import io.github.vikie1.whatsoftware.pojo.SoftwareAttributesPojo;
import io.github.vikie1.whatsoftware.service.ControllerLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/api")
public class PostRequestsController {

    @Autowired
    ControllerLinkService controllerLinkService;

    //New Software Entity
    @PostMapping("/soft")
    public void postNewSoftwareDetails(@RequestBody SoftwareAttributesPojo softwareAttributesPojo){ controllerLinkService.postSoftwareDetails(softwareAttributesPojo); }

}
