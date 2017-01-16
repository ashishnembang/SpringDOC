package com.packt.webstore.validator;



	import java.math.BigDecimal;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;

import com.packt.webstore.domain.Product;

	public class StockMaximumValidator implements ConstraintValidator<StockMaximum, Product>

	{
		BigDecimal maxValue = null;
		
  	    public void initialize( StockMaximum constraintAnnotation) {
	    	
  	    	// get annotation parameter value
 	    	int maximum = constraintAnnotation.maximum();
	    	maxValue = new BigDecimal(maximum);

	    }

	    @Override
	    public boolean isValid(Product product, final ConstraintValidatorContext context) {
		    BigDecimal unitPrice;
		    Long unitsInStock;

		    unitsInStock = product.getUnitsInStock();
		    unitPrice = product.getUnitPrice();
		    
	    	BigDecimal currentValue = new BigDecimal(0);
	    	if (unitsInStock > 0 ) {
	    	 currentValue = unitPrice.multiply(new BigDecimal(unitsInStock));
	    	}
	    	System.out.println("first value"+ currentValue);
	    	
	    	if (currentValue.compareTo(maxValue) >= 0){
	    		System.out.println(currentValue.compareTo(maxValue));
	    		return false;
	    	}
	    		
	    	return true;
	    }
	}

