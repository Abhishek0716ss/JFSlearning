package com.bootA.ecom_server.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "Product")
public class Product {
 @Id
 private String id;
 private String name;
 private String description;
 private String tages;
 private String category;
 private String price;
 private String stock;
 
 public String getId() {
	return id;
 }
 public void setId(String id) {
	this.id = id;
 }
 public String getName() {
	return name;
 }
 public void setName(String name) {
	this.name = name;
 }
 public String getDescription() {
	return description;
 }
 public void setDescription(String description) {
	this.description = description;
 }
 public String getTages() {
	return tages;
 }
 public void setTages(String tages) {
	this.tages = tages;
 }
 public String getCategory() {
	return category;
 }
 public void setCategory(String category) {
	this.category = category;
 }
 public String getPrice() {
	return price;
 }
 public void setPrice(String price) {
	this.price = price;
 }
 public String getStock() {
	return stock;
 }
 public void setStock(String stock) {
	this.stock = stock;
 }
 
 
  
}
