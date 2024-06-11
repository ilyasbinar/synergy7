package com.example.threadDemo.service;

public class OrderRunnable implements Runnable{
    private long price;
    private long quantity;
    private long subtotal;

    public OrderRunnable(long harga, long kuantitas) {
        this.price = harga;
        this.quantity = kuantitas;
    }

    @Override
    public void run() {
        try {
            System.out.println("calculating..."+price);
            Thread.sleep(5000);
            subtotal= price * quantity;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public long getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(long subtotal) {
        this.subtotal = subtotal;
    }
}
