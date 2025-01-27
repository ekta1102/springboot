 package com.sathya.springbootmvc.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.sathya.springbootmvc.Repository.ProductRepository;
import com.sathya.springbootmvc.productEntity.ProductEntity;
import com.sathya.springbootmvc.productmodel.ProductModel;


@org.springframework.stereotype.Service
public class productService 
{
    @Autowired
    ProductRepository repository;
   

	public void saveProductDetails(ProductModel productModel)
    {
    	double stockvalue = productModel.getPrice() * productModel.getQuantity();

        
        double discountPrice = productModel.getPrice() * productModel.getDiscountrate() / 100;

        
        double offerPrice = productModel.getPrice() - discountPrice;

        
        double taxprice = productModel.getPrice()* 18/100;
        
        
        double finalPrice = offerPrice + taxprice;
        
        
        ProductEntity productEntity = new ProductEntity();
        
        productEntity.setName(productModel.getName());
        productEntity.setBrand(productModel.getBrand());
        productEntity.setMadein(productModel.getMadein());
        productEntity.setPrice(productModel.getPrice());
        productEntity.setQuantity(productModel.getQuantity());
        productEntity.setDiscountrate(productModel.getDiscountrate());
        
        
        productEntity.setDiscountprice(discountPrice);
        productEntity.setTaxprice(taxprice);
        productEntity.setOfferprice(offerPrice);
        productEntity.setFinalprice(finalPrice);
        productEntity.setStockvalue(stockvalue);
         
         
        repository.save(productEntity);
        
       }

	public List<ProductEntity> getallproducts() {
		List<ProductEntity> product = repository.findAll();
		return product;
	}

	
	public ProductEntity searchById(long id)
	{
		Optional<ProductEntity> optionaldata = repository.findById(id);
		if(optionaldata.isPresent())
		{
			ProductEntity product = optionaldata.get();
			return product;
		}
		else
		{
			return null;
		
	    }
   }
	
	
     public void deletebyid(long id)
     {
    	 repository.deleteById(id);
     }
     
     
     public ProductModel editbyid(long id)
     {
    	 Optional<ProductEntity> optionaldata = repository.findById(id);
    	 if(optionaldata.isPresent())
    	 {
    		 ProductEntity product = optionaldata.get();
    		 
    		 ProductModel productModel = new ProductModel();
    		 productModel.setName(product.getName()); 
    		 productModel.setBrand(product.getBrand());
    		 productModel.setMadein(product.getMadein());
    		 productModel.setPrice(product.getPrice());
    		 productModel.setQuantity(product.getQuantity());
    		 productModel.setDiscountrate(product.getDiscountrate());
    		 return productModel;
    		 }
    	 else
    	 {
    		 return null;
    	 }
     }

    public void updatebyid(long id, ProductModel productModel)
    {
    	Optional<ProductEntity>optionaldata = repository.findById(id);
    	 if(optionaldata.isPresent())
    	 {
    		 ProductEntity product = optionaldata.get();
    		 product.setName(productModel.getName());
    		 product.setBrand(productModel.getBrand());
    		 product.setMadein(productModel.getMadein());
    		 product.setPrice(productModel.getPrice());
    		 product.setQuantity(productModel.getQuantity());
    		 product.setDiscountrate(productModel.getDiscountrate());
    		 
    		 double discountprice=productModel.getDiscountrate()*productModel.getPrice()/100;
    		  
    		 product.setDiscountprice(discountprice);
    		 
    		 double offerprice;
    		 offerprice = productModel.getPrice()-discountprice;
    		 
    		 double taxprice;
    		 taxprice = 0.18*offerprice;
    		 
    		 double stockvalue;
    		 stockvalue = productModel .getPrice()*productModel.getQuantity();
    		 
    		 double finalprice;
    		 finalprice=offerprice+taxprice;
    		 
    		 product.setOfferprice(offerprice);
    		 product.setTaxprice(taxprice);
    		 product.setStockvalue(stockvalue);
    		 product.setFinalprice(finalprice);
    		 
    		 repository.save(product);
    		 }
		
	}
    
  }
     



    
    	