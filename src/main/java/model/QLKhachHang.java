package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import util.FileHelper;

/**
 *
 * Họ tên sinh viên:
 */
public class QLKhachHang {

    private ArrayList<KhachHang> dsKhachHang;

    public QLKhachHang() {
        dsKhachHang = new ArrayList<>();
    }

    public QLKhachHang(ArrayList<KhachHang> dsKhachHang) {
        this.dsKhachHang = dsKhachHang;
    }

    public ArrayList<KhachHang> getDsKhachHang() {
        return dsKhachHang;
    }

    public void setDsKhachHang(ArrayList<KhachHang> dsKhachHang) {
        this.dsKhachHang = dsKhachHang;
    }

    public void DocKhachHang(String filename) {
        //sinh viên viết code 
        ArrayList<String> data = FileHelper.readFileText(filename); //doc file
        //đổ dữ liệu vào danh sách
        dsKhachHang.clear();
        for (String item : data) {
            String[] arr = item.split(";");
            KhachHang sv = new KhachHang();
            sv.setMaso(arr[0]);
            sv.setHoten(arr[1]);
            sv.setSonhankhau(Integer.parseInt(arr[2]));
            sv.setChisocu(Double.parseDouble(arr[3]));
            sv.setChisomoi(Double.parseDouble(arr[4]));
            dsKhachHang.add(sv);
        }
    }

    public boolean GhiHoaDon(String filename) {
        //sinh viên viết code 
        ArrayList<String> data = new ArrayList<>();
        for (KhachHang kh : dsKhachHang) {
            String info = kh.getMaso() + ";" + kh.getHoten() + ";" + kh.getSonhankhau() + ";" + kh.getChisocu() + ";" + kh.getChisomoi();
            data.add(info);
        }
        return FileHelper.writeFileText(filename, data);
    }

    public void sapXepTheoMucTieuThu() {
        //sinh viên viết code     
        Comparator<KhachHang> cmp = (kh1, kh2) -> {
            return Double.compare(kh1.getTieuThu(), kh2.getTieuThu());
        };
        Collections.sort(dsKhachHang, cmp);
    }

    public double getTieuThuCaoNhat() {
        double max = 0;
        return max;
    }

    public double getTieuThuThapNhat() {
        double min = dsKhachHang.get(0).getTieuThu();
        for(KhachHang kh: dsKhachHang){
        if(kh.getTieuThu()<min){
            min=kh.getTieuThu();
        }
        }
        return min;
    }

    public double getTieuThuTrungBinh() {
        double tong=0;
         for(KhachHang kh: dsKhachHang){
        tong+=kh.getTieuThu();
        }
        return tong/dsKhachHang.size();
    }
}
