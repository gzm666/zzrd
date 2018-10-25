package com.culture.zzrd.guoview;

import android.content.Context;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by guozm on 2018/8/14.
 */

public class ShowTextView extends TextView {

    private float spacing = Spacing.NORMAL;
    private CharSequence originalText = "";

    public ShowTextView(Context context) {
        super(context);
    }

    public ShowTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ShowTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    /**
     * 获取字间距
     */
    public float getSpacing() {
        return this.spacing;
    }

    /**
     * 设置间距
     */
    public void setSpacing(float spacing) {
        this.spacing = spacing;
        applySpacing();
    }

    public void setText(String str, boolean isSimple) {
        originalText = str;
        doAiSize(isSimple);
        super.setText(str, BufferType.NORMAL);
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        originalText = text;
        doAiSize(false);
        super.setText(text, type);
//        applySpacing();
    }

    private void doAiSize(boolean isSimple) {
        if (originalText.length() > 300) {
            if (isSimple) {
                super.setTextSize(12);
            } else {
                super.setTextSize(16);
            }
        } else if (originalText.length() <= 300 && originalText.length() > 150) {
            if (isSimple) {
                super.setTextSize(14);
            } else {
                super.setTextSize(18);
            }
        } else if (originalText.length() <= 150 && originalText.length() > 50) {
            if (isSimple) {
                super.setTextSize(16);
            } else {
                super.setTextSize(20);
            }
        } else if (originalText.length() <= 50 && originalText.length() > 0) {
            if (isSimple) {
                super.setTextSize(18);
            } else {
                super.setTextSize(22);
            }
        }
    }

    @Override
    public CharSequence getText() {
        return originalText;
    }

    /**
     * 扩大文字空间
     */
    private void applySpacing() {
        if (this == null || this.originalText == null) return;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < originalText.length(); i++) {
            builder.append(originalText.charAt(i));
            if (i + 1 < originalText.length()) {
                //如果前后都是英文，则不添加空格，防止英文空格太大
//                if (isEnglish(originalText.charAt(i) + "") && isEnglish(originalText.charAt(i + 1) + "")) {
//                } else {
//                    // \u00A0 不间断空格 碰见文字追加空格
//                    builder.append("\u00A0");
//                }
                if (isChinese(originalText.charAt(i) + "") && isChinese(originalText.charAt(i + 1) + "")) {
                    builder.append("\u00A0");
                    builder.append("\u00A0");
                }
//                builder.append("\u00A0");
            }
        }
        // 通过SpannableString类，去设置空格
        SpannableString finalText = new SpannableString(builder.toString());
        // 如果当前TextView内容长度大于1，则进行空格添加
//        if (builder.toString().length() > 1) {
//            for (int i = 1; i < builder.toString().length(); i += 2) {
//                // ScaleXSpan 基于x轴缩放  按照x轴等比例进行缩放 通过字间距+1除以10进行等比缩放
//                finalText.setSpan(new ScaleXSpan((spacing + 1) / 10), i, i + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//            }
//        }
        super.setText(finalText, BufferType.SPANNABLE);
    }

    public class Spacing {
        public final static float NORMAL = 0;
    }

    /**
     * 判断是否是英语
     */
    public static boolean isEnglish(String charaString) {
        return charaString.matches("^[a-zA-Z]*");
    }

    public static boolean isChinese(String charaString) {
        String regEx = "[\u4e00-\u9fa5]";
        return charaString.matches(regEx);
    }


}
