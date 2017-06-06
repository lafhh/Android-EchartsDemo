package com.laf.androidechartdemo.tablelayout;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.laf.androidechartdemo.R;

/**
 * Created by js_gg on 2017/6/6.
 */

public class TableLayout9_1 extends Activity {

    private boolean mShrink;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.table_layout_9_1);

        final TableLayout table = (TableLayout) findViewById(R.id.menu);
        Button button = (Button) findViewById(R.id.toggle);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mShrink = !mShrink;
                table.setColumnShrinkable(0, mShrink);
            }
        });

        mShrink = table.isColumnShrinkable(0);
        appendRow(table);
    }

    private void appendRow(TableLayout table) {
        TableRow row = new TableRow(this);

        TextView label = new TextView(this);
        label.setText("Quit");
        label.setPadding(3,3,3,3);

        TextView shutcut = new TextView(this);
        shutcut.setText("Ctrl+Q");
        shutcut.setPadding(3, 3, 3, 3);
        shutcut.setGravity(Gravity.RIGHT | Gravity.TOP);

        row.addView(label, new TableRow.LayoutParams());
        row.addView(shutcut, new TableRow.LayoutParams());

        table.addView(row, new TableLayout.LayoutParams());
    }
}
