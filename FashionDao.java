package com.jsp.FashionDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.FashionComponent.FashionEntity;

@Repository
public class FashionDao {
	
	@Autowired
	EntityManager manager;
	
	@Autowired
	EntityTransaction transaction;
	
	int abc=0;
	
	//insert a value here
	public String insertion(FashionEntity product)
	{
		transaction.begin();
		manager.persist(product);
		transaction.commit();
		return "saved";
		
	}
	
	//find a product
	public List<FashionEntity> findProduct(String name)
	{
		Query q= manager.createQuery("select f from FashionEntity f where f.name=?1");
		q.setParameter(1,name);
		
		List<FashionEntity> li = q.getResultList();
		if(li!=null)
		{
			return li;
		}
		else
		{
			return null;
		}
	}
	
	//display all products
	public List<FashionEntity> allProducts()
	{
		Query q= manager.createQuery("select f from FashionEntity f");
		List<FashionEntity> li= q.getResultList();
		if(li!=null)
		{
			return li;
		}
		else
		{
			return null;
		}
		
	}
	
	//buy a product  //2.add to cart operation
	public FashionEntity productBuy(String name, int newQuantity)
	{
		List<FashionEntity> list= findProduct(name);
		
		
		
		
		
		if(list.isEmpty())
		{
			return null;
		}
		else
		{
			
			FashionEntity pro= list.get(0);
			if(pro!=null && pro.getQuantity() >=newQuantity)
			{
				
			int value= pro.getQuantity()- newQuantity;
			pro.setQuantity(value);
			pro.setNewQuantity(newQuantity);
			int rupees= pro.getPrice()*newQuantity;
			pro.setTotalPrice(rupees);
			transaction.begin();
			manager.merge(pro);
			transaction.commit();
			return pro;
			}
			else
			{
				
				return null;
			}
		}
		
		
		
		
		
		
		
		
	}
	
	//price operation
	public int priceOperation(String name)
	{
		Query query= manager.createQuery("select p from FashionEntity p where p.name=?1");
		query.setParameter(1,name);
		List<FashionEntity> li= query.getResultList();
		
		if(li.isEmpty())
		{
			return 0;
		}
		else
		{
			
			FashionEntity pro= li.get(0);
			int value= pro.getPrice();
			return value;
		}
	}
	
	//Increase Quantity
	public String increaseQuantityPro(String name,int increase)
	{
		List<FashionEntity> li= findProduct(name);
		
		if(li.isEmpty())
		{
			return "unsuccessfull";
		}
		else
		{
			FashionEntity fash= li.get(0);
			int value= fash.getQuantity()+increase;
			fash.setQuantity(value);
			transaction.begin();
			manager.merge(fash);
			transaction.commit();
			return "successfully  increased";
			
		}
		
		
		
	}
	

	//delete the product
		public String rem(String name)
		{
			Query q= manager.createQuery("select s from FashionEntity s where s.name=?1");
			q.setParameter(1,name);
			List<FashionEntity> li= q.getResultList();
			
			if(li.isEmpty())
			{
				return "Unsuccessfully completed";
			}
			else
			{
				FashionEntity pro= li.get(0);
				if(pro!=null)
				{
					transaction.begin();
					manager.remove(pro);
					transaction.commit();
					return "deleted successfully";
				}
				else
				{
					return "Unsuccessfully completed";
				}
				
			}
			
		}



	
	//admin username and password verification...
	public String  adminVerification(String userName,int password)
	{
		if(userName.equals("mathi") && password==3322)
		{
			return "verified";
		}
		else
		{
			return "not verified";
		}
	}

}
