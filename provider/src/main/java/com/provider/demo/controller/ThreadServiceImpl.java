package com.provider.demo.controller;

import org.springframework.stereotype.Service;

@Service
public class ThreadServiceImpl implements Runnable {

    public void test(){
        System.out.println("当前线程为:"+Thread.currentThread());
        for(int i =0;i<10;i++){
            System.out.println("线程"+Thread.currentThread()+"在工作");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        test();
    }
}
