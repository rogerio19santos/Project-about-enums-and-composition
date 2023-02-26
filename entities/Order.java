package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
private LocalDate moment;
private OrderStatus status;
private Client client;
private List <OrderItem> items = new ArrayList<>();

public Order() {
	
}

public Order(LocalDate moment, OrderStatus status, Client client) {
	
	this.moment = moment;
	this.status = status;
	this.client = client;
	
}

public List<OrderItem> getItems() {
	return items;
}



public LocalDate getMoment() {
	return moment;
}
public void setMoment(LocalDate moment) {
	this.moment = moment;
}
public OrderStatus getStatus() {
	return status;
}
public void setStatus(OrderStatus status) {
	this.status = status;
}



public void addItem (OrderItem item) {
	items.add(item);
}

public void removeItem(OrderItem item) {
	items.remove(item);
}

public Double total() {
	double sum = 0;
	for(int i = 0; i < items.size(); i++) {
		sum+= items.get(0).subTotal();
	}
	return ;
}



}
