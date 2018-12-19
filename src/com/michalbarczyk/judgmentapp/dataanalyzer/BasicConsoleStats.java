package com.michalbarczyk.judgmentapp.dataanalyzer;


public abstract class BasicConsoleStats implements IConsoleStats {

    protected RawDataKeeper rawDataKeeper;
    protected String result;

    protected BasicConsoleStats(RawDataKeeper rawDataKeeper) {

        this.rawDataKeeper = rawDataKeeper;
        this.result = null;
    }


}
