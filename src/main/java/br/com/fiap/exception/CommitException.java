package br.com.fiap.exception;

public class CommitException extends Exception {

  public CommitException() {
    super("Error committing");
  }

  public CommitException(String message) {
    super(message);
  }

}
