package com.example.todowidget;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Memo画面の代わりのスタブクラス
 * 値が正常に入っていることを確認する
 */
public class StubMemoActivity extends Activity
{
	final String TAG = "ToDoWidget";
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		// 適当なレイアウトを作る
		LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.VERTICAL);
		setContentView(layout);

		TextView textView = new TextView(this);
		textView.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.LayoutParams.WRAP_CONTENT));
		textView.setText("メモのテストだよ！");
		layout.addView(textView);

		// インテントからMemo画面に渡す予定の時間を
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		String type = bundle.getString("TYPE");

		// [DEBUG]
		// 値が正常に入っている調べる
		Log.d(TAG, "START : " + type);
	}
}
