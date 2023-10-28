package org.example.sboot.service;

import io.ebean.config.CurrentUserProvider;
import org.springframework.stereotype.Component;

/**
 * Provides the current user to EbeanServer.
 */
@Component
public class CurrentUser implements CurrentUserProvider {

  @Override
  public Object currentUser() {
    // Returning null here to ensure test fails when pulling wrong property
    return null;
  }
}
