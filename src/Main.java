import java.io.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int znach = 0;
        while (true) {
            System.out.println("Введите число x");
            if (sc.hasNextInt()) {
                znach = sc.nextInt();
                break;
            } else {
                System.out.println("Введено неверное значение");
                sc.next();
            }
        }

        System.out.println("Ответ:");
        math firstmath = new math(znach);
        firstmath.otvet();


        System.out.println("Введите saveБ что бы сохранить/Введите upload, что бы загрузить");
        String vvod = "";
        while (true){
            vvod = sc.next();
            if(vvod.equals("save")||vvod.equals("Save")){
                try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\79623\\OneDrive\\Рабочий стол\\lab-15\\lab-15.txt"))){
                    oos.writeObject(firstmath);
                    oos.writeInt(znach);
                    oos.writeDouble(firstmath.y);
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
            if(vvod.equals("upload")||vvod.equals("Upload")){
                try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\79623\\OneDrive\\Рабочий стол\\lab-15\\lab-15.txt"))){
                    math secmath = (math)ois.readObject();
                    secmath.otvet();
                }
                catch (IOException ex) {
                    System.out.println(ex.getMessage());
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
class math implements Serializable {
    private double x;
    public double y;
    math(int x){
        this.x=x;
    }
    void otvet(){
        double y = x-Math.sin(x);
        System.out.println(y);
    }
}
