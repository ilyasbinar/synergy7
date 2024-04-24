package com.example.xx2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
public class HomeController {
    private final static Logger LOG = LoggerFactory.getLogger(HomeController.class);

    final
    MovieController movieController;

    public HomeController(MovieController movieController) {
        this.movieController = movieController;
    }

    public void home() throws InterruptedException {
        StopWatch sw = new StopWatch();
        sw.start();
        Thread.sleep(2000);
        //Logic Method
        movieController.displayShowingMovie();
        //End of Logic Method
        sw.stop();
        if(sw.getTotalTimeSeconds()>1){
            LOG.warn("Method running selama >1 detik: "+sw.getTotalTimeMillis());
        }
    }

    public void home2(){
        movieController.displayShowingSoonMovie();
    }
}
