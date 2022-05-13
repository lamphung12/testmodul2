package Model;

public class DanhBa {
    private int id;
    private String soDienThoai;
    private String nhomDanhBa;
    private String hoVaTen;
    private String gioiTinh;
    private String diaChi;
    private String ngaySinh;
    private String thuDienTu;


    public DanhBa() {
    }

    public DanhBa(int id,String soDienThoai, String nhomDanhBa, String hoVaTen,
                  String gioiTinh, String diaChi, String ngaySinh, String thuDienTu) {
        this.id = id;
        this.soDienThoai = soDienThoai;
        this.nhomDanhBa = nhomDanhBa;
        this.hoVaTen = hoVaTen;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.ngaySinh = ngaySinh;
        this.thuDienTu = thuDienTu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getNhomDanhBa() {
        return nhomDanhBa;
    }

    public void setNhomDanhBa(String nhomDanhBa) {
        this.nhomDanhBa = nhomDanhBa;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getThuDienTu() {
        return thuDienTu;
    }

    public void setThuDienTu(String thuDienTu) {
        this.thuDienTu = thuDienTu;
    }

    @Override
    public String toString() {
        return id +
                "," + soDienThoai +
                "," + nhomDanhBa +
                "," + hoVaTen +
                "," + gioiTinh +
                "," + diaChi +
                "," + ngaySinh +
                "," + thuDienTu ;
    }
}
