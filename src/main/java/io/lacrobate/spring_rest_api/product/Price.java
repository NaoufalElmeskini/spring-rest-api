package io.lacrobate.spring_rest_api.product;

import lombok.*;

@Data
@NoArgsConstructor
public class Price {
	private long productId;
	private double priceAmount;
	private double discount;
}