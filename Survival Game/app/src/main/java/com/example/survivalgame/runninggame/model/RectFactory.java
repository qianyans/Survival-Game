package com.example.survivalgame.runninggame.model;

// We understand that importing Rect in model will violate MVP rule. The model should not have
// android class. We can solve it by creating our own Rect class. But this will be redundant and
// unnecessarily increase the number of classes.
import android.graphics.Rect;

public class RectFactory {
  /** the factory used to create the rect. */
  public Rect createRect(int left, int top, int right, int bottom) {
    return new Rect(left, top, right, bottom);
  }
}
