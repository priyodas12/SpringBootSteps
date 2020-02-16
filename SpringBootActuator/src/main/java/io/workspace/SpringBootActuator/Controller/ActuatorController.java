package io.workspace.SpringBootActuator.Controller;

import java.util.concurrent.atomic.AtomicLong;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.workspace.SpringBootActuator.Model.Greetings;

@RestController
@RequestMapping("/app")
public class ActuatorController {
	
	@GetMapping("/actuator-demo")
	public String actuatorDemoPage() {
		return "ActuatorDemo";
	}
	
   	  private static final String template = "Hello, %s!";
	  private final AtomicLong counter = new AtomicLong();

	  @GetMapping("/greet/{name}")
	  @ResponseBody
	  public Greetings sayHello(@PathVariable(required = true) String name) {
	    return new Greetings(counter.incrementAndGet(), String.format(template, name));
	  }

}
