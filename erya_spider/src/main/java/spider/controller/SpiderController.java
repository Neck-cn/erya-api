package spider.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spider.processor.EryaProcessor;
import spider.service.SpiderService;

import javax.annotation.Resource;

@RestController("spider")
public class SpiderController {
    @Resource(name = "spiderService")
    private SpiderService spiderService;
    private EryaProcessor eryaProcessor;

    public SpiderController(EryaProcessor eryaProcessor) {
        this.eryaProcessor = eryaProcessor;
    }

    @PostMapping("getAnswer")
    public void getAnswer(@RequestParam("question") String question) {
        spiderService.findAnswer(question);
    }

    @PostMapping("spider/{thread}/{sleep}")
    public void spider(@RequestParam("url") String url, @PathVariable("thread") int thread, @PathVariable("sleep") int sleep) {
        eryaProcessor.start(url, thread, sleep);
    }
}