package com.cts.mc.product.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.mc.product.exception.ProductException;
import com.cts.mc.product.model.Product;
@SpringBootTest
class ProductControllerTest {

		@Autowired
		private ProductController productController;

		@Test
		 void addProductTest() throws ProductException {
			Product product = new Product();
			product.setProductId(4l);
			product.setProductName("123 test");
			product.setPrice(10.0);
			product.setOffer(10.0);
			product.setStock(123);
			Product addProduct = productController.addProduct(product);

			assertNotNull(addProduct);
			assertNotNull(addProduct.getOffer());
			assertNotNull(addProduct.getPrice());
			assertNotNull(addProduct.getProductId());
			assertNotNull(addProduct.getProductName());
			assertEquals(123, addProduct.getStock());
		}

		@Test
		 void updateProductTest() throws ProductException {
			Product product = new Product(2l,"123 test123",123,10.0,10.0);
			Product addProduct = productController.updateProduct(product);

			assertNotNull(addProduct);
		}

		@Test
		 void getProductByIdTest() throws ProductException {

			Product productById = productController.getProductById(14L);

			assertNotNull(productById);
		}

		  @Test
		  public void deleteProductTest() throws ProductException {
		  
		  String deleteProduct = productController.deleteProduct(13L);
		  
		  assertEquals("Product Deleted Successfully", deleteProduct);; }
		 

	}

