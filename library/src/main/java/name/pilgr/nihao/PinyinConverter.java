package name.pilgr.nihao;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * This class is NiHao main interface.
 * there are two methods you can call them to convert the chinese to pinyin.
 * PinyinUtil.toPinyin(Context context,char c);
 * PinyinUtil.toPinyin(Context context,String hanzi);
 * <p/>
 * User: Ryan
 * Date: 11-5-29
 * Time: 21:13
 */
public class PinyinConverter {

    private static final String TAG = "PinyinConverter";

    private RandomAccessFile mSourceFile = null;

    public PinyinConverter(Context context) {
        try {
            mSourceFile = new RandomAccessFile(PinyinSource.readOrCreateFromFile(context), "r");
        } catch (FileNotFoundException e) {
            Log.e(TAG, "Couldn't init Pinyin Converter", e);
        }
    }

    public void recycle() {
        try {
            if (mSourceFile != null) {
                mSourceFile.close();
            }
        } catch (IOException e) {
        }
    }

    /**
     * Convert chinese to pinyin
     *
     * @param c the chinese character
     * @return pinyin
     */
    public String toPinyin(char c) {
        if (c == 0x3007) return "ling";
        if (c < 4E00 || c > 0x9FA5) {
            return "";
        }
        try {
            long sp = (c - 0x4E00) * 6;
            mSourceFile.seek(sp);
            byte[] buf = new byte[6];
            mSourceFile.read(buf);
            return new String(buf).trim();
        } catch (IOException e) {
            return "";
        }
    }

    public String toPinyin(String hanzi) {
        return toPinyin(hanzi, null);
    }

    /**
     * Convert chinese to pinyin
     *
     * @param hanzi the chinese string
     * @return pinyin
     */
    public String toPinyin(String hanzi, String separator) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < hanzi.length(); i++) {
            char ch = hanzi.charAt(i);
            final String pinyin = toPinyin(ch);
            if (!TextUtils.isEmpty(pinyin)) {
                sb.append(pinyin);
            } else {
                sb.append(ch);
            }
            if (!TextUtils.isEmpty(separator)) {
                sb.append(separator);
            }
        }
        return sb.toString();
    }
}
