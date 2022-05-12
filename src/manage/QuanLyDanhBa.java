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

    public int findByNumberPhone(int soDienThoai){
        for (int i = 0; i <danhBaList.size() ; i++) {
            if (danhBaList.get(i).getId()==soDienThoai){
                return i;
            }
        }
        return -1;
    }

    public void edit(int soDienThoai,DanhBa danhBa){
        int index= findByNumberPhone(soDienThoai);
        if(index==-1){
            System.out.println("Khong tim duoc danh ba voi so dien thoai tren");
        }
        else{
            danhBaList.set(index,danhBa);
        }
    }

    public void delete (int soDienThoai){
        int viTriXoa =findByNumberPhone(soDienThoai);
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
