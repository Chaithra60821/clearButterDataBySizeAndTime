package com.thrajon.clearButterDataBySizeAndTime;

public class ProducerTask implements Runnable{

  @Override
  public void run() {
      int i = 1;
      while (true) {
        try {
          Thread.sleep(1000);
          SharedResource.sharedResources.add("a" + i++);
          System.out.println("Length of the array : " + SharedResource.getLength());
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
  }
}
