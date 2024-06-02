package dev.wdrap.restcontroller.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.wdrap.restcontroller.domain.Path;
import dev.wdrap.restcontroller.service.PathService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/v1/path")
public class PathControlller {

    private final PathService pathService;

    public PathControlller(PathService pathService) {
        this.pathService = pathService;
    }
    
    @GetMapping()
    public ResponseEntity<Path> getPath() {
        Path path = pathService.getPath();

        return new ResponseEntity<>(path, HttpStatus.OK);
    }

}
