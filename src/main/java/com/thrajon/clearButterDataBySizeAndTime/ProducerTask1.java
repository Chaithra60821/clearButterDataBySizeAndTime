package com.thrajon.clearButterDataBySizeAndTime;

public class ProducerTask1 implements Runnable{

  @Override
  public void run() {
      System.out.println("Proder1");
      int i = 1000;
      while (i < 1003) {
        try {
          Thread.sleep(100);
          SharedResource.sharedResources.add("a" + i++);
          System.out.println("Length of the array produer1 : " + SharedResource.getLength());
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
  }
}
