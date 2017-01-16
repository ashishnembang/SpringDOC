package mum.edu.formatter;

import java.util.Locale;

import org.springframework.expression.ParseException;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import mum.edu.domain.ISBNumber;

public class ISBNFormatter implements Formatter<ISBNumber> {

	  public String print(ISBNumber isbn, Locale locale) {
 	       return isbn.getStart() + "-" +
	    		isbn.getMiddle() + "-" + isbn.getEnd();
	  }

	  public ISBNumber parse(String source, Locale locale)
	      throws ParseException {
		  ISBNumber isbNumber= null;
 	try {
			int start = Integer.parseInt(source.substring(0, 3));
		    int middle = Integer.parseInt(source.substring(4, 7));
		    int end = Integer.parseInt(source.substring(8, 11));
		    isbNumber =  new ISBNumber(start, middle, end);
 	} catch (Exception e){
 		System.out.println(e.getMessage());
 	}
	    return isbNumber;
	  }
}