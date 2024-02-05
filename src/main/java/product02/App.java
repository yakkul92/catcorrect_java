package product02;

import java.util.*;

public class App 
{
    public static void main( String[] args )
    {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        final String[] TYPES = {"黒","白","茶トラ"};
        ArrayList<Cat> list = new ArrayList<>();
        System.out.println("***猫集め***");
        while(true){
            System.out.println("1.集める 2.遊ぶ 3.終了>>");
            int select = sc.nextInt();
            if (select == 3) {
                System.out.println("***結果***");
                for (Cat c :list) {
                    System.out.println(c.showStatus());                    
                }
                System.out.println("また遊んでね。おしまい");
                return;
            }
            if (select == 1) {
                String type = TYPES[rand.nextInt(TYPES.length)];
                System.out.printf("%s猫を見つけた!%n", type);
                System.out.print("この猫に名前を付けてください>>");
                String name = sc.next();
                Cat cat = new Cat(name, type);
                list.add(cat);
                System.out.println(cat.name+"が仲間に加わった");
            }else
            if (select == 2) {
                if (list.size() == 0) {
                    System.out.println("まだ遊ぶ猫がいません。。。");
                    continue;
                }
                for(int i = 0; i<list.size(); i++){
                    System.out.printf("%d・・・%s%n", i, list.get(i).showStatus());
                }
                System.out.println("どの猫と遊びますか？>>");
                int no = sc.nextInt();
                list.get(no).play();
                sortCat(list);
            }
        }
    }

    static void sortCat(ArrayList<Cat> list){
        for(int i = 0; i<list.size()-1; i++){
            for (int j = 0; j < list.size(); j++) {
                if (list.get(i).intimacy < list.get(j).intimacy) {
                    Cat temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }    
            }
        }
    }

}

class Cat{
    String name;
    String type;
    int intimacy=0;

    Cat(String name, String type){
        this.name=name;
        this.type=type;
    }

    String showStatus(){
        return String.format("%s[%s](%d)", this.name, this.type, this.intimacy);
    }

    void play(){
        System.out.println(this.name+"と遊んだ");
        System.out.println("...");
        System.out.println(this.name+"の親密度がアップした！");
    }

}
