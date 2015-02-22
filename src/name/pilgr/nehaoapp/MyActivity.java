/**
 * Copyright (C) 2011 Pinyin for Android Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package name.pilgr.nehaoapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import name.pilgr.pipinyin.PiPinyin;

/**
 * this is a demo activity for PiPinyin library
 * you can running this activity in your mobile to check it .
 *
 * User: Ryan
 * Date: 11-5-29
 * Time: 21:13
 */
public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        TextView textView = (TextView) findViewById(R.id.demotext);
        TextView textView1 = (TextView) findViewById(R.id.demotext1);
        final PiPinyin piPinyin = new PiPinyin(this);
        textView.setText(piPinyin.toPinyin("这是一个测试", " "));
        textView1.setText(String.valueOf(piPinyin.toPinyin('我')));
        piPinyin.recycle();
    }
}
