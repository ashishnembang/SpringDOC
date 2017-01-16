package com.packt.webstore.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;

@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = StockMaximumValidator.class)
@Documented
public @interface StockMaximum {

    String message() default "{StockMaximum.Product.validation}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    // Annotation parameter @StockMaximum(maximum)
    int maximum();
 
}
