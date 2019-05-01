package com.han.helloconsumer.config;

import brave.sampler.Sampler;

public class AlwaysSampler extends Sampler {
    @Override
    public boolean isSampled(long l) {
        return true;
    }
}
