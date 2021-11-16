package cn.tx.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: wangjian
 * @createTime: 2021/11/8 11:43
 * @description:
 * 点菜的主程序
 *
 */
public class DishApp {
    //主函数
    //提前准备一些菜品，展示给用户，同时用户可以点菜
    //定义集合（表示小饭店拥有的菜品）,List<Dish> 只能存Dish类型的数据
    static List<Dish> dishList = new ArrayList<>();
    //用户已点的菜品集合
    static List<Dish> personDish = new ArrayList<>();
    public  static void main(String[] args){
            //先初始化菜品
            initDish();
            //小饭店就会做5个菜
            //创建扫描器对象，获取到控制台输入的内容
            Scanner s = new Scanner(System.in);
            //写死循环
            while (true){
                //给用户展示主菜单
                showMenu();
                //获取内容;它有阻塞作用
                int num = s.nextInt();
                //判断用户输入的数字
                switch (num){
                    case 1:
                        while (true) {
                            //把饭店菜单展示给用户
                            showDishMenu();
                            //获取用户输入的内容
                            int id = s.nextInt();
                            //判断
                            if(id == 0){
                                break;
                            }
                            //从饭店的集合中获取到菜品的对象
                            //集合的索引:  0  1 2 3 4
                            Dish dish = dishList.get(id - 1);
                            System.out.println("亲，您点了"+dish.name+"菜");
                            //用户点一个，存储一个
                            personDish.add(dish);
                        }



                    case 2:
                        showPersonDish();

                        break;
                    case 3:
                        //买单的方法
                        buy();
                        //return 和 break的区别,break是把switch结束
                        //return是把整个程序结束
                        return;

                }
            }


    }

    //展示饭店菜单
    public static void showDishMenu(){
        System.out.println("----请您点菜----");
        //遍历集合
        for (int i = 0;i < dishList.size();i++){
            //从集合中使用i获取每一个菜品对象
            Dish dish = dishList.get(i);
            System.out.println(dish.id+"\t"+dish.name+"\t"+dish.price);
        }
        System.out.println("----输入序号点菜,按0返回上一集----");

    }
    //客户已点
    public static void showPersonDish(){
        System.out.println("----您已点的菜品----");
        //遍历已点的集合,增强for循环  Dish dish : personDish
        for (Dish dish : personDish){
            System.out.println(dish.id+"\t"+ dish.name+"\t"+ dish.price);
        }
    }
    //买单
    public static void buy(){
        System.out.println("----请稍等,正在结算----");
        //定义总金额
        double total = 0f;
        //遍历已点菜品
        for (Dish dish : personDish){
            //单价的累加
            total +=dish.price;
        }
        System.out.println("亲，您本次消费了: "+total+"元");

    }


    //展示主菜单
    public static void showMenu(){
        System.out.println("------主菜单-------");
        System.out.println("菜单\t\t\t 1");
        System.out.println("已点菜品\t\t 2");
        System.out.println("买单\t\t\t 3");
        System.out.println("-----根据编号请选择服务------");
    }

    //初始化菜品
    public static void initDish(){
        Dish dish = new Dish(1,"香辣肉丝",29.0);
        dishList.add(dish);
        Dish dish2 = new Dish(2,"炖王八",59.0);
        dishList.add(dish2);
        //存放菜品
        dishList.add(new Dish(3,"家常凉菜",21.0));
        dishList.add(new Dish(4,"地三鲜",24.0));
        dishList.add(new Dish(5,"油闷大虾",55.0));

    }
}
