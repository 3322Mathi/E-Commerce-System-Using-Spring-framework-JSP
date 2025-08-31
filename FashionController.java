package com.jsp.FashionController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.FashionComponent.FashionEntity;
import com.jsp.FashionDAO.FashionDao;

@Controller
public class FashionController {
	
	@Autowired
	FashionDao dao;
	
	//For total add to cart list here....
	List<FashionEntity> totalList= new ArrayList<FashionEntity>();
	
	//Admin portal
	@RequestMapping("/admin")
	public String adminSystem() {
		return "adminfile";
	}
	
	@RequestMapping("/gotit")
	public ModelAndView adminCorrection(@RequestParam String userName,int password)
	{
		String ver = dao.adminVerification(userName,password);
		if(ver.equals("verified"))
		{
			ModelAndView mv= new ModelAndView();
			mv.addObject("message","Welcome Admin");
			mv.setViewName("adminPortal");
			return mv;
		}
		else
		{
			ModelAndView mv= new ModelAndView();
			mv.addObject("message","Please Enter Correct UserName or Passoword");
			mv.setViewName("error");
			return mv;
		}
	}
	
	//customer portal
	@RequestMapping("/customer")
	public ModelAndView customerPortal()
	{
		ModelAndView mv= new ModelAndView();
		mv.addObject("message","Welcome to Mens Fashion");
		mv.setViewName("customerWebsite");
		return mv;
	}
	
	//insert controller...
	@RequestMapping("/insert")
	public ModelAndView getinsert()
	{
		ModelAndView mv= new ModelAndView();
		mv.addObject("product",new FashionEntity());
		mv.setViewName("add");
		return mv;
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public  String getInitialize(@ModelAttribute FashionEntity product)
	{
		return dao.insertion(product);
	}
	
	
	
	//find and display...
	@RequestMapping("/find")
	public String getFind()
	{
		return "productFind";
	}
	
	@RequestMapping("/search")
	public ModelAndView getSearch(@RequestParam String name)
	{
		List<FashionEntity> list= dao.findProduct(name);
		if(list!=null)
		{
			ModelAndView mv= new ModelAndView();
			mv.addObject("listed",list);
			mv.setViewName("display");
			return mv;
		}
		else
		{
			ModelAndView mv= new ModelAndView();
			mv.addObject("message","Not found");
			mv.setViewName("error");
			return mv;	
		}
	}
	
	//Display All
	@RequestMapping("/pdisplay")
	public ModelAndView productsDisplay()
	{
		List<FashionEntity> list= dao.allProducts();
		if(list!=null)
		{
			ModelAndView mv= new ModelAndView();
			mv.addObject("listed",list);
			mv.setViewName("displayAll");
			return mv;
		}
		else
		{
			ModelAndView mv= new ModelAndView();
			mv.addObject("message","Not found Data");
			mv.setViewName("error");
			return mv;
		}
	}
	
	//add to cart user interface
	@RequestMapping("/buy")
	public String  buyProduct()
	{
		return "buyer";
	}
	
	//view price
	@RequestMapping("/viewPrice")
	public ModelAndView priceView(@RequestParam String name)
	{
		           int rup=  dao.priceOperation(name);
		           ModelAndView mv= new ModelAndView();
		          if(rup!=0)
		          {
		        	  mv.addObject("amount",rup);
			          mv.setViewName("buyer");
			           return mv;
		          }
		          else {
		        	  mv.addObject("message","Product Not Found");
			           mv.setViewName("error");
			           return mv;
		          }
	}
	
	@RequestMapping("/purchase")
	public ModelAndView available(@RequestParam String name, int newQuantity)
	{
		FashionEntity li= dao.productBuy(name,newQuantity);
		
		
		if(li!=null)
		{
			totalList.add(li);
			ModelAndView mv= new ModelAndView();
			mv.addObject("cartList",totalList);
			mv.setViewName("buyer");
			return mv;
		}
		else
		{
			ModelAndView mv= new ModelAndView();
			mv.addObject("message","Please check Product Quantity or Product is available");
			mv.setViewName("error");
			return mv;
		}
	}
	
	
	 
	 //Final stage of bill
	//Purchase Successfully
	@RequestMapping("/totalProduct")
	public ModelAndView  totalPurchase()
	{
		List<FashionEntity> fe = totalList;
		ModelAndView mv= new  ModelAndView();
		mv.addObject("listed",fe);
		mv.setViewName("bill");
		return mv;
		
	}
	
	
	//increase quantity
	@RequestMapping("/increaseQuant")
	public String increaseQuantity()
	{
		return "quantity";
	}
	

	//Delete a product 
			@RequestMapping("/delete")
			public String deleteThings()
			{
				return "deleteProduct";
			}
			
			@RequestMapping("/dlt")
			public ModelAndView remov(@RequestParam String name)
			{
				String var= dao.rem(name);
				ModelAndView mv= new ModelAndView();
				if(var.equals("deleted successfully"))
				{
					mv.addObject("message",var);
					mv.setViewName("error");
					return mv;
				}
				else
				{
					mv.addObject("message",var);
					mv.setViewName("error");
					return mv;
				}
				
			}


	
	//admin increase...
	@RequestMapping("/inc")
	public ModelAndView adminIncrease(@RequestParam String name, int increase)
	{
		String li= dao.increaseQuantityPro(name,increase);
		if(li.equals("successfully  increased"))
		{
			ModelAndView mv= new ModelAndView();
			mv.addObject("message","successfully increased");
			mv.setViewName("error");
			return mv;
		}
		else
		{
			ModelAndView mv= new ModelAndView();
			mv.addObject("message","Product is Not Available");
			mv.setViewName("error");
			return mv;
		}
		
	}

}
