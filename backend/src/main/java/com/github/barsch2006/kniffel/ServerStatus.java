package com.github.barsch2006.kniffel;

import lombok.*;

@Getter // this will generate getters for all attributes
@Setter // this will generate setter for all attributes
public class ServerStatus {
    private long serverTime;
    private String serverVersion;
    private String serverName;
    private String serverStatus;
}
