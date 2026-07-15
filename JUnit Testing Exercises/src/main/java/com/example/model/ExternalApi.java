package com.example.model;

/**
 * Represents a dependency on an external system (e.g. a remote API client).
 * This is the interface Mockito will mock throughout the Mockito exercises.
 */
public interface ExternalApi {

    String getData();

    void performAction();

    void performAction(String param);
}
