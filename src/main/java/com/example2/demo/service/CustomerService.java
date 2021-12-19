package com.example2.demo.service;

import com.example2.demo.domain.CustomerInfo;
import com.example2.demo.repos.CustomerinfoRepos;

import java.io.BufferedReader;
import java.io.FileReader;
public class CustomerService{
    public static void main(String[] args){
        String file="src\\customers.csv";
        BufferedReader reader=null;
        String line="";
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while((line=bufferedReader.readLine())!=null){
                String data[]=line.split( ";");
                CustomerInfo customerInfo=new CustomerInfo();
                CustomerInfo.setcustomerpartykey(data[0]);
                CustomerInfo.setresidentialcountrycd(data[1]);
                CustomerInfo.setpartyopendate(data[2]);
                CustomerinfoRepos.save(customerInfo);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            reader.close();
        }

        }
}
