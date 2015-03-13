package com.artivisi.training.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

public class PerformanceCalculator implements MethodInterceptor {

    public Object invoke(MethodInvocation mi) throws Throwable {
        // mulai menghitung waktu
        StopWatch sw = new StopWatch("Method simpan");
        
        sw.start();
        
        System.out.println("======= Sebelum menjalankan method aslinya ========");
        
        System.out.println("Nama Method : "+mi.getMethod().getName());
        System.out.println("Jumlah argumen : "+mi.getArguments().length);
        System.out.println("Tipe data argumen : ");
        for (Object arg : mi.getArguments()) {
            System.out.println("- "+arg.getClass().getName());
        }
        
        System.out.println("======= Sebelum menjalankan method aslinya ========");
        
        // pemanggilan method yang asli
        Object hasil = mi.proceed();
        
        System.out.println("===== Selesai menjalankan method ======");
        
        System.out.println("Return value : "+hasil);
        
        System.out.println("===== Selesai menjalankan method ======");
        
        
        sw.stop();
        System.out.println("Waktu eksekusi : "+sw.prettyPrint());
        
        // setelah selesai, kembalikan return value dari method yang asli
        return hasil;
    }
    
}
