package manage;

import Model.DanhBa;
import file.ManagerFile;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class QuanLyDanhBa  {
    List<DanhBa> danhBaList = new ArrayList<>();

    public List<DanhBa> getDanhBaList() {
        return danhBaList;
    }

    public void setDanhBaList(List<DanhBa> danhBaList) {
        this.danhBaList = danhBaList;
    }


    public QuanLyDanhBa() throws FileNotFoundException {
        danhBaList= ManagerFile.readFromFile();
    }

    public void add(DanhBa danhBa){
        danhBaList.add(danhBa);
    }

    public void display(){
        for (int i = 0; i <danhBaList.size() ; i++) {
            System.out.println(danhBaList.get(i));
        }
    }

    public int findByNumberPhone(String soDienThoai){
        for (int i = 0; i <danhBaList.size() ; i++) {
            if (danhBaList.get(i).getSoDienThoai().contains(soDienThoai)){
                return i;
            }
        }
        return -1;
    }

    public void edit(String soDienThoai,DanhBa danhBa){
        int indexOf = findByNumberPhone(soDienThoai);
        if (indexOf == -1) {
            System.out.println( "Không tìm được số ĐT nào như trên" );
        } else {
            danhBaList.set(indexOf, danhBa);
            System.out.println( "Bạn đã sửa thành công thông tin danh bạ" );
        }
    }

    public void delete (String soDienThoai){
        int viTriXoa = findByNumberPhone(soDienThoai);
        if(viTriXoa==-1){
            System.out.println("Khong co trong danh sach");
        }else{
            danhBaList.remove(viTriXoa);
        }
    }
    public void exit(){
        System.exit(0);
    }


}
