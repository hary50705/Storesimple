package com.storesimple.module;

import android.content.Context;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

/**
 * 基本的動畫 (透明度、縮放、移動、旋轉)
 *
 * @author Kurt
 */
public class CustomAnimation {
    private Animation myAnimation_Alpha;
    private Animation myAnimation_Scale;
    private Animation myAnimation_Translate;
    private Animation myAnimation_Rotate;
    private Context context;

    public CustomAnimation(Context context) {
        this.context = context;
    }

    /**
     * 透明度動畫
     *
     * @param from        開始的透明度
     * @param to          結束的透明度
     * @param duration    動畫執行時間
     * @param repeatCount 重覆動畫次數
     * @param fillAfter   動畫執行完是否停留在執行的狀態
     * @param startOffset 執行前的等待時間
     */
    public void setAnimationAlpha(float from, float to,
                                  int duration, int repeatCount, boolean fillAfter, int startOffset) {
        if(myAnimation_Alpha!=null){
            myAnimation_Alpha=null;
        }
        myAnimation_Alpha = new AlphaAnimation(from, to);
        myAnimation_Alpha.setDuration(duration);
        myAnimation_Alpha.setRepeatCount(repeatCount);
        myAnimation_Alpha.setFillAfter(fillAfter);
        myAnimation_Alpha.setStartOffset(startOffset);
    }

    /**
     * 大小縮放動畫
     *
     * @param fromX       開始 X的大小
     * @param toX         結束 X的大小
     * @param fromY       開始 Y的大小
     * @param toY         結束 Y的大小
     * @param duration    動畫執行時間
     * @param repeatCount 重覆動畫次數
     * @param fillAfter   動畫執行完是否停留在執行的狀態
     * @param startOffset 執行前的等待時間
     */
    public void setAnimationScale(float fromX, float toX, float fromY, float toY,
                                  int duration, int repeatCount, boolean fillAfter, int startOffset) {

        if(myAnimation_Scale!=null){
            myAnimation_Scale=null;
        }
        myAnimation_Scale = new ScaleAnimation(fromX, toX, fromY, toY,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        myAnimation_Scale.setDuration(duration);
        myAnimation_Scale.setRepeatCount(repeatCount);
        myAnimation_Scale.setFillAfter(fillAfter);
        myAnimation_Scale.setStartOffset(startOffset);
    }

    /**
     * 移動動畫
     *
     * @param fromX       開始 X的位置
     * @param toX         結束 X的位置
     * @param fromY       開始 Y的位置
     * @param toY         結束 Y的位置
     * @param duration    動畫執行時間
     * @param repeatCount 重覆動畫次數
     * @param fillAfter   動畫執行完是否停留在執行的狀態
     * @param startOffset 執行前的等待時間
     */
    public void setAnimationTranslate(float fromX, float toX, float fromY, float toY,
                                      int duration, int repeatCount, boolean fillAfter, int startOffset) {
        if(myAnimation_Translate!=null){
            myAnimation_Translate=null;
        }
        myAnimation_Translate = new TranslateAnimation(fromX, toX, fromY, toY);
        myAnimation_Translate.setDuration(duration);
        myAnimation_Translate.setRepeatCount(repeatCount);
        myAnimation_Translate.setFillAfter(fillAfter);
        myAnimation_Translate.setStartOffset(startOffset);
    }

    /**
     * @param fromDegrees 開始的旋轉角度
     * @param toDegrees   結束的旋轉角度
     * @param duration    動畫執行時間
     * @param repeatCount 重覆動畫次數
     * @param fillAfter   動畫執行完是否停留在執行的狀態
     * @param startOffset 執行前的等待時間
     */
    public void setAnimationRotate(float fromDegrees, float toDegrees,
                                   int duration, int repeatCount, boolean fillAfter, int startOffset) {

        if(myAnimation_Rotate!=null){
            myAnimation_Rotate=null;
        }
        myAnimation_Rotate = new RotateAnimation(fromDegrees, toDegrees,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        myAnimation_Rotate.setDuration(duration);
        myAnimation_Rotate.setRepeatCount(repeatCount);
        myAnimation_Rotate.setFillAfter(fillAfter);
        myAnimation_Rotate.setStartOffset(startOffset);

    }

    public Animation getAlpha() {
        return myAnimation_Alpha;
    }

    public Animation getRotate() {
        return myAnimation_Rotate;
    }

    public Animation getTranslate() {
        return myAnimation_Translate;
    }

    public Animation getScale() {
        return myAnimation_Scale;
    }
}
