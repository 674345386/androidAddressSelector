package cp.addressselector.demo;

import android.text.TextUtils;
import android.widget.TextView;

/**
 * Created by CP on 2017/5/11. 14:04.
 */

public class Tools {
    public static boolean isHaveAllContent(TextView[] views){
        for (TextView e :views){
            if(TextUtils.isEmpty(e.getText()));
            return false;
        }
        return true;
    }
}
