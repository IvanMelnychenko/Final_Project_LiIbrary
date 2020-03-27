package ua.testing.confige;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public enum PasswordCoder {
  ENCODER;
  @Autowired
  private BCryptPasswordEncoder encoder;

  PasswordCoder() {
    encoder = new BCryptPasswordEncoder();
  }

  public BCryptPasswordEncoder getEncoder() {
    return encoder;
  }


}
