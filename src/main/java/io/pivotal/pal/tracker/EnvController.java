package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    private final String port;
    private final String memoryLimit;
    private final String instanceIndex;
    private final String instanceAddress;

    /*

        PORT
        MEMORY_LIMIT
        CF_INSTANCE_INDEX
        CF_INSTANCE_ADDR

         */
    public EnvController(@Value("${port:NOT SET}") String port,
                         @Value("${memory.limit:NOT SET}") String memoryLimit,
                         @Value("${cf.instance.index:NOT SET}") String instanceIndex,
                         @Value("${cf.instance.addr:NOT SET}") String instanceAddress) {
        this.port = port;
        this.memoryLimit = memoryLimit;
        this.instanceIndex = instanceIndex;
        this.instanceAddress = instanceAddress;
    }

    @GetMapping("/env")
    public Map<String, String> getEnv() {
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("PORT",this.port);
        resultMap.put("MEMORY_LIMIT",this.memoryLimit);
        resultMap.put("CF_INSTANCE_INDEX",this.instanceIndex);
        resultMap.put("CF_INSTANCE_ADDR",this.instanceAddress);
        return resultMap;
    }
}
