package my.p2.service;

import my.p2.bean.Customer;

/**
 * @author crazy邹
 * @create 2021/2/25 17:45
 */
public class CustomerList {
    /**
     * 保存客户数组 customers
     * total记录已保存客户对象的数量
    */
    private Customer[] customers;
    private int total = 0;

    /**
     * 用来初始化数组customer数组的构造器
     * @param totalCustomer，指定数组的长度
     */
    public CustomerList(int totalCustomer){
        customers = new Customer[totalCustomer];
    }

    /**
     * 将指定的客户添加到数组中
     * @param customer
     * @return true:添加成功，false：添加失败
     */
    public boolean addCustomer(Customer customer){
        if(total >= customers.length){
            return false;
        }else{
            customers[total] = customer;
            total++;
            return true;
            //或者customer[customer++]
        }

    }

    /**
     *修改指定位置索引位置的客户信息
     * @param index
     * @param cust
     * @return true:修改成功 false:修改失败
     */
    public boolean replaceCustomer(int index,Customer cust){
        if(index < 0 || index >= total){
            return false;
        }
        customers[index] = cust;
        return true;
    }

    /**
     * 删除指定位置索引位置上的客户
     * @param index
     * @return true:删除成功 false:删除失败
     */
    public boolean deleteCustomer(int index){
        if(index < 0 || index >= total){
            return false;
        }
        for(int i = index;i < total - 1;i++){
            customers[i] = customers[i+1];
        }
        customers[--total] = null;
        return true;
    }

    /**
     * 获取所有客户信息
     * @return
     */
    public Customer[] getAllCustomer() {
        Customer[] custs = new Customer[total];
        for(int i =0;i < total;i++){
            custs[i] = customers[i];
        }
        return custs;
    }

    /**
     * 获取指定索引位置上的客户
     * @param index
     * @return 如果找到了元素，则放回，如果没找到，则放回NULL
     */
    public Customer getCustomer(int index){
        if(index < 0 || index >= total){
            return null;
        }
        return customers[index];
    }

    /**
     * 获取存储的客户的数量
     * @return
     */
    public int getTotal(){
        return total;
    }

}
