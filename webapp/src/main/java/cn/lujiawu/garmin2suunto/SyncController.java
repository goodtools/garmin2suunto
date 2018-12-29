package cn.lujiawu.garmin2suunto;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@RestController
@RequestMapping(value = "sport/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Slf4j
public class SyncController {

    @Autowired
    private ReactorSyncService syncService;

    @GetMapping(value = "/sync", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> sync() {
        return syncService.startSync();
    }

    @GetMapping(value = "/sse", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> flux() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Flux<String> stringFlux = Flux.fromStream(IntStream.rangeClosed(1, 3).boxed()).map(integer -> gen());
        stopWatch.stop();
        log.info("async flux >>> " + stopWatch.toString());
        return stringFlux;
    }

    private String gen() {
        try {
            TimeUnit.SECONDS.sleep(1L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Date().toString();
    }

}
