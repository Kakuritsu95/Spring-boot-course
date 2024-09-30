package com.kakuritsu.aopdemo.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;
@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService {
    @Override
    public String getFortune(boolean tripWire) {
        if(tripWire) throw new RuntimeException("something went wrong !");
      try {
      TimeUnit.SECONDS.sleep(5);
      }
      catch (InterruptedException exc){
          throw new RuntimeException(exc);
        }
      return "Expect heavy traffic!!!";
    }
@Override
    public String getFortune(){
     return this.getFortune(false);
}
    }
