package com.thrajon.clearButterDataBySizeAndTime;

import java.time.Instant;

public class ScheduledTask implements Runnable{

  @Override
  public void run() {
   synchronized (SharedResource.sharedResources) {
      System.out.println("TIME :" + Instant.now());
      SharedResource.sharedResources.forEach(i -> System.out.print(i + ","));
      System.out.println("\n");
      SharedResource.sharedResources.clear();
      SharedResource.sharedResources.notify();
   }
  }
}
