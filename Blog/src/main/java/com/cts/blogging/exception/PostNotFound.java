package com.cts.blogging.exception;

public class PostNotFound extends RuntimeException{
 public PostNotFound(String msg) {
	super(msg);
}
}
