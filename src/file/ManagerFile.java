package file;

import Model.DanhBa;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerFile {
 public static void writeToFile(List<DanhBa>danhBaList) throws IOException {
     File file = new File("file.csv");
     PrintWriter printWriter = new PrintWriter(file);
     BufferedWriter bufferedWriter = new BufferedWriter(printWriter);
     printWriter.println("id,soDienThoai,nhom,hoVaTen,gioiTinh,diaChi,ngaySinh,email");
     for (int i = 0; i <danhBaList.size() ; i++) {
         printWriter.println(danhBaList.get(i));
     }
     printWriter.close();
     bufferedWriter.close();

 }

 public static List<DanhBa> readFromFile() throws FileNotFoundException {
     File file =new File("file.csv");
     List<DanhBa> danhBaList = new ArrayList<>();
     Scanner sc =new Scanner(file);
     sc.nextLine();
    while (sc.hasNext()){
        String line = sc.nextLine();
        if(line.equals("")){
            break;
        }
        String arr[] = line.split(",");
        danhBaList.add(new DanhBa(Integer.parseInt(arr[0]),arr[1],arr[2],arr[3],arr[4]
                ,arr[5],arr[6],arr[7]));

    }
    return danhBaList;
 }


}
