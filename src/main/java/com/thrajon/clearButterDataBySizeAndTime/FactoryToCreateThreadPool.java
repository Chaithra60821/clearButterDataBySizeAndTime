package com.thrajon.clearButterDataBySizeAndTime;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class FactoryToCreateThreadPool {
  private static FactoryToCreateThreadPool factoryToCreateThreadPool;

  ScheduledExecutorService scheduleAtFixedRate;
  ScheduledFuture scheduledFuture;
  private FactoryToCreateThreadPool() {
    scheduleAtFixedRate = Executors.newScheduledThreadPool(4);
    scheduleAtFixedRate.submit(new ProducerTask());
    scheduleAtFixedRate.submit(new ProducerTask1());
    scheduledFuture = scheduleAtFixedRate.scheduleAtFixedRate(new ScheduledTask()
        , 0,4000, TimeUnit.MILLISECONDS);
    scheduleAtFixedRate.submit(new SizeCheckTask());

  }

  public static FactoryToCreateThreadPool getInstance() {
    if (factoryToCreateThreadPool == null) {
      synchronized (FactoryToCreateThreadPool.class) {
        if (factoryToCreateThreadPool == null) {
          factoryToCreateThreadPool = new FactoryToCreateThreadPool();
        }
      }
    }
    return factoryToCreateThreadPool;
  }

}
