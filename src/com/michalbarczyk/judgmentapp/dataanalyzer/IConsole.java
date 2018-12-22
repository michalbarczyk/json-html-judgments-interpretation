package com.michalbarczyk.judgmentapp.dataanalyzer;

public interface IConsole {

    /**
     *
     * @return function name user can type into a console
     * in order to get answer
     */
    String getName();

    /**
     *
     * @return description how the function works
     */
    String getHelp();
}
