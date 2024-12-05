package vn.edu.tnut.app2;

import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView ekq; //bien dùng chung cho cả class
    EditText tensv,sotien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ekq = (TextView) this.findViewById(R.id.txtKQ);
        tensv=(EditText) this.findViewById(R.id.tensv);
        sotien=(EditText) this.findViewById(R.id.sotien);

        tensv.requestFocus();
    }

    public void Boi_tien(View view) {
        //lấy đc tên, tiền, if tiên > T0: s1 => kq,  else : s2=>kq

        String ten=tensv.getText().toString();
        Float  tien=Float.parseFloat  (sotien.getText().toString());


//        String hello = getString(R.string.hello);
//        String rich = getString(R.string.rich);
//        String not_rich = getString(R.string.not_rich);
//
//        String html=hello+ten+". ";
//        if(tien>100)
//            html+=rich;
//        else
//            html+=not_rich;

        BOI_TOAN bt = new BOI_TOAN(this);
        bt.ten=ten;
        bt.tien=tien;
        String html = bt.Boi_ngay();


        ekq.setMovementMethod(LinkMovementMethod.getInstance());
        ekq.setText(Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY));
    }

    public void Xoa_sach(View view) {
        ekq.setText("");
        tensv.setText("");
        sotien.setText("");
        tensv.requestFocus();
    }
}