package com.cts.blogging.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "auth-service", url = "localhost:8082/api/auth")
public interface AuthFeign {
	
	@GetMapping("/validate")
	public ResponseEntity<Boolean> validate(@RequestHeader(name="Authorization") String token1 );

	@GetMapping("/username")
	public String getUserName(@RequestHeader(name="Authorization") String token1 );
	
}
