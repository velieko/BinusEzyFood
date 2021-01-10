package com.example.binusezyfood;

import java.util.ArrayList;

public class OrderList extends ArrayList<Order> {

    public static ArrayList<Order> orderlist;
    private OrderList(){
        orderlist= new ArrayList<Order>();
    }

    private static OrderList instance;
    public synchronized static OrderList getinstance(){
        if (instance == null) instance = new OrderList();
        return instance;
    }

    public static int total (){
       int count=0;
       orderlist= OrderList.getinstance();
        for(Order x : orderlist){
            count = count + x.getTotal();
        }
        return count;
    }
    public static void delete(){
        orderlist = OrderList.getinstance();
        orderlist.clear();
    }

}
