package com.example.administrator.commondialog;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by Liu on 2018/6/14.
 * 弹窗工具类
 */

public class DialogUtils {

    private Context mContext;

    private int layoutId;
    private int layoutPosition;
    private int padingTop;
    private int padingBottom;
    private int padingRight;
    private int padingLeft;
    private int dialogAnimaType;

    private static Dialog dialog= null;

    private DialogUtils.ViewInterface listener;

    private DialogUtils() {

    }

    /**
     * 静态内部类的方式构建单例模式
     */

    private static class DialogHolder{

        private static DialogUtils instance= new DialogUtils();

    }

    public static DialogUtils getInstance(){
        return DialogHolder.instance;
    }

    /**
     * 传入上下文
     * @param context
     * @return
     */

    public final DialogUtils with(Context context){
        this.mContext= context;
        return this;

    }

    /**
     * 传入弹窗需要的布局
     * @param layoutId
     * @return
     */

    public final DialogUtils setlayoutId(int layoutId){
        this.layoutId= layoutId;
        return this;

    }

    /**
     * 设置弹窗的位置
     * @param layoutPosition
     * @return
     */

    public final DialogUtils setlayoutPosition(int layoutPosition){
        this.layoutPosition= layoutPosition;
        return this;

    }

    /**
     * 设置弹窗的动画
     * @param dialogAnimaType
     * @return
     */
    public final DialogUtils setlayoutAnimaType(int dialogAnimaType){
        this.dialogAnimaType= dialogAnimaType;
        return this;

    }

    /**
     * 设置弹窗距离屏幕的距离
     * @param padingLeft
     * @param padingTop
     * @param padingRight
     * @param padingBottom
     * @return
     */
    public final DialogUtils setlayoutPading(int padingLeft,int padingTop,int padingRight,int padingBottom){
        this.padingLeft= padingLeft;
        this.padingTop= padingTop;
        this.padingRight= padingRight;
        this.padingBottom= padingBottom;
        return this;

    }
    public interface ViewInterface {
        void getChildView(View view, int layoutResId);
    }

    /**
     * 设置子View
     *
     * @param listener ViewInterface
     * @return Builder
     */
    public DialogUtils setOnChildViewclickListener(DialogUtils.ViewInterface listener) {
        this.listener = listener;
        return this;
    }

    /**
     * 设置弹窗消失
     */
    public static void dismiss(){

        if (dialog!=null && dialog.isShowing()){
            dialog.dismiss();
        }
    }

    public void show(){
        switch (dialogAnimaType){
            case 0:
                //自下而上动画

                    dialog = new Dialog(mContext, R.style.ActionSheetDialogStyle);

                break;
            case 1:
                //淡入淡出缩放动画

                    dialog = new Dialog(mContext, R.style.ActionSheetDialogStyle1);

                break;
        }

        View view = LayoutInflater.from(mContext).inflate(layoutId, null);

        dialog.setContentView(view);

        if (listener != null && layoutId != 0) {
            listener.getChildView(view, layoutId);
        }

        //获得dialog的window窗口
        Window window = dialog.getWindow();
        //设置dialog在屏幕位置
        window.setGravity(layoutPosition);

        window.getDecorView().setPadding(padingLeft, padingTop, padingRight, padingBottom);
        //获得window窗口的属性
        WindowManager.LayoutParams lp = window.getAttributes();
        //设置窗口宽度为充满全屏
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        //设置窗口高度为包裹内容
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        //将设置好的属性set回去
        window.setAttributes(lp);
        dialog.show();
    }


}
