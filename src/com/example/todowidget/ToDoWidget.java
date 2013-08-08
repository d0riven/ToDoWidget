package com.example.todowidget;

import com.example.todowidget.R;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;


public class ToDoWidget extends AppWidgetProvider
{
	final String TAG = "ToDoWidget";

	final String[] TYPES =
		{
			"CAMERA",
			"PALLETE",
			"PEN",
			"MIC"
		};

	final int[] BUTTON_IDs =
		{
			R.id.camera_launch_button,
			R.id.palette_launch_button,
			R.id.pen_launch_button,
			R.id.mic_launch_button
		};

	/**
	 * コンストラクタ
	 */
	public ToDoWidget()
	{
	}

	/**
	 * 指定された時間毎（最短30分）にウィジェットを更新する関数
	 */
	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds)
	{
		final int NUMBER_OF_BUTTON = TYPES.length;

		RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.layout_widget);

		// ペンディングインテントを必要な数だけ作成する
		for(int i = 0; i < NUMBER_OF_BUTTON; ++i)
		{
			final String type = TYPES[i];
			final int button_id = BUTTON_IDs[i];

			// ここのアクティビティをMemo画面に書き換える
			Intent intent = new Intent(context, StubMemoActivity.class);

			// ここに個別のタイプをセットし起動の分岐を行う
			intent.setType(type);
			// [DEBUG]
			// Memo画面での処理の分岐のIDを渡す
			// ※ 結合時に要書き換え
			intent.putExtra("TYPE", type);
			Log.d(TAG, type);
			PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

			views.setOnClickPendingIntent(button_id, pendingIntent);
		}

		appWidgetManager.updateAppWidget(appWidgetIds, views);
	}
}
