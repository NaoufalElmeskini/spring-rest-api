package io.lacrobate.spring_rest_api.product;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Product {
	private long id;
	private String name;
	private Price price;
}