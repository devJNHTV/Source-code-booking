package com.poly.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShoppingcartController {
		@RequestMapping("cart/view")
		public String list()
		{
			return "cart/view";
		}
		
}