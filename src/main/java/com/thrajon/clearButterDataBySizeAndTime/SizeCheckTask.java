package com.thrajon.clearButterDataBySizeAndTime;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class SizeCheckTask implements Runnable{

  @Override
  public void run() {
    System.out.println("Size check thread is started");
   while (true) {
     try {
      synchronized (SharedResource.sharedResources) {
          if (SharedResource.getLength() >= 6) {
            System.out.println(
                "T3 Size is: " + SharedResource.getLength());
            FactoryToCreateThreadPool.getInstance().scheduledFuture.cancel(true);
            Future f = FactoryToCreateThreadPool.getInstance().scheduleAtFixedRate.submit(new ScheduledTask());
            //TODO: If we do f.get also call should get block until that another thread finish that
            // task but it is not working that way. Need to check
              while (!f.isDone()) {
                SharedResource.sharedResources.wait();
              }
            System.out.println("Done : " + f.isDone());
            FactoryToCreateThreadPool.getInstance().scheduledFuture =
                FactoryToCreateThreadPool.getInstance().scheduleAtFixedRate.scheduleAtFixedRate(new ScheduledTask()
                , 0,4000, TimeUnit.MILLISECONDS);
         }
       }
      } catch (Exception e) {
        e.printStackTrace();
      }
     }
  }
}
