package vn.edu.tnut.app2;

import static android.provider.Settings.System.getString;

import android.content.Context;

public class BOI_TOAN {
    private Context context;
    // Constructor nhận Context
    public BOI_TOAN(Context context) {
        this.context = context;
    }
    //ko đổi tên class sau khi đã tạo ra nó
    //muốn đổi: backup code, xoá class, tạo lại
    public String ten;
    public Float tien;
    public String Boi_ngay(){
        //lấy chuỗi chuẩn bị trước
        //tự động lấy EN or VI tuỳ system language
        String hello = context.getString(R.string.hello);
        String rich = context.getString(R.string.rich);
        String not_rich = context.getString(R.string.not_rich);

        //thuật toán: chỉ thuần tuý java, ko liên quan đến android
        String html=hello+ten+". ";
        if(tien>100)
            html+=rich;
        else
            html+=not_rich;

        //trả về kq
        return html;
    }
}
