package com.github.barsch2006.kniffel;

import org.springframework.web.bind.annotation.*;
import java.lang.management.*;

@RestController
@RequestMapping("/api/server-info")
@CrossOrigin
public class ServerStatusController {
    @PostMapping("/thread-dump")
    public void threadDump() {
        // this code writes the StackTrace of all threads to stdout
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        for (ThreadInfo threadInfo : threadMXBean.dumpAllThreads(true, true)) {
            System.out.println(threadInfo);
        }
    }

    @GetMapping("/status")
    public ServerStatus getServerStatus() {
        ServerStatus serverStatus = new ServerStatus();
        serverStatus.setServerTime(System.currentTimeMillis());
        serverStatus.setServerVersion("1.0.0");
        serverStatus.setServerName("Kniffel Server");
        serverStatus.setServerStatus("OK");
        return serverStatus;
    }
}
