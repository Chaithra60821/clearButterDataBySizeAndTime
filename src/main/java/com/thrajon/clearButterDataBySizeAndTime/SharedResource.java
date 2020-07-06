package com.thrajon.clearButterDataBySizeAndTime;

import java.util.ArrayList;
import java.util.List;

public class SharedResource {
  public static List<String> sharedResources = new ArrayList<>();

  public List<String> getSharedResources() {
    return sharedResources;
  }

  public void setSharedResources(String sharedResource) {
    sharedResources.add(sharedResource);
  }

  public static int getLength(){
    return sharedResources.size();
  }
}
