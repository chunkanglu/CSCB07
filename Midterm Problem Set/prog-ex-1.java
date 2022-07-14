import java.util.Scanner;
import java.io.File;
import java.util.regex.*;

class PostalCode {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("[A-Z&&[^DFIOQU]][\\d][A-Z&&[^DFIOQU]] [\\d][A-Z&&[^DFIOQU]][\\d]");
        Scanner s = new Scanner(System.in);
        String path = s.nextLine();
        File dir = new File(path);
        File[] files = dir.listFiles();
        for(File f: files) {
            String name = f.getName();
            Matcher m = p.matcher(name);
            if(m.find()){
                System.out.println(name);
            }
        }
	s.close();
    }
}
