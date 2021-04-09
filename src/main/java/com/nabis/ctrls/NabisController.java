/**
 * 
 */
package com.nabis.ctrls;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author padoya
 *
 */
@Controller
public class NabisController {
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/test")
	public String test() {
		System.out.println("11111");
		return "test";
	}
	
}
