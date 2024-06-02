package dev.wdrap.restcontroller.service;

import org.springframework.stereotype.Service;

import dev.wdrap.restcontroller.domain.Path;

@Service
public class PathService {

    public Path getPath() {
        return new Path(0f, 0f);
    }
}
