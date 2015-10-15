package com.yuikya.musicplayer;

        import android.app.Activity;
        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.ViewGroup.MarginLayoutParams;
        import android.widget.Button;
        import android.widget.LinearLayout.LayoutParams;
        import android.widget.TextView;

        import com.yuikya.musicplayer.widget.FlowLayout;


/**
 * @ClassName: MainActivity
 * @author cjj
 * @date 2015年3月18日 下午2:48:27
 * @Description:流逝布局的实现
 */
public class FlowActivity extends Activity {

    /**
     * 测试数据
     */
    private String[] values = new String[]
            { "hello", "lucy", "linearlayout", "cjj", "mainActivity",
                    "hello", "lucy", "linearlayout","df","fd" ,"cjj", "mainActivity",
                    "hello", "lucy", "linearlayout", "cjj","mainActivity", };

    /**
     * 自定义流式布局
     */
    private FlowLayout mFlowlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flow);

        mFlowlayout = (FlowLayout) findViewById(R.id.flowlay);
        initData();
    }

    private void initData() {
//		for (int i = 0; i < values.length; i++) {
//			Button button = new Button(this);
//			MarginLayoutParams lp = new MarginLayoutParams(LayoutParams.WRAP_CONTENT,
//					LayoutParams.WRAP_CONTENT);
//			button.setText(values[i]);
//			mFlowlayout.addView(button, lp);
//
//		}

        LayoutInflater inflater = LayoutInflater.from(this);
        for (int i = 0; i < values.length; i++) {
            TextView tv = (TextView) inflater.inflate(R.layout.tv,mFlowlayout, false);
            tv.setText(values[i]);
            mFlowlayout.addView(tv);
        }
    }
}
