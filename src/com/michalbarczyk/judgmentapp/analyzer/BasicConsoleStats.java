package com.michalbarczyk.judgmentapp.analyzer;


public abstract class BasicConsoleStats implements IConsoleStats {

    protected RawDataKeeper rawDataKeeper;
    protected String result;

    protected BasicConsoleStats(RawDataKeeper rawDataKeeper) {

        this.rawDataKeeper = rawDataKeeper;
        this.result = null;
    }


}
