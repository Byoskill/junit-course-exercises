package com.byoskill.training.junit.realapp.junitrealapp.adapters.anime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MediaTitle { 
    public String english;
    @JsonProperty("native")
    public String nativeName;
}
