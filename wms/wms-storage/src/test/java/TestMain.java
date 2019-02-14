import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;

/**
 * Created by Makkah at 2019/1/22 15:45
 */
public class TestMain {
    static int hello() {
        return 5;
    }

    public static void main(String[] args) {
//      System.getProperties().list(System.out);
//      double pi = Math.PI;
//      new ArrayList<>().forEach(System.out::println);
        Hello hello1 = str -> System.out.println(str + 1);
//      如果只是print(str)，可以省去->，直接写成：
        Hello hello = System.out::println;
        hello.helloo("yyyyy");
        hello.helloo("88888");
        hello1.helloo("aaaaaaaaaaaa");
        hello1.helloo("666666");
        Hello hello2 = str -> System.getProperties().list(System.out);
        hello2.helloo("wtever");
        /*
        1 直接在本类中定义interface并声明方法,且只能有一个方法，才能成为@FunctionalInterface,如果有多个方法，就不能使用Lambda语法，而是使用new关键字创建实例，同时Override接口的所有方法
        2 通过具体的方法内容以创建interface实例
        3 用实例调用方法，就是调用了第2步的具体方法内容
        4 Lambda表达式内部如果需要访问外部变量，则该变量必须是final的，可以不用final修饰，但后续绝不能对其值进行更改，否则会编译出错
        */

        Hi hi = new Hi() {
            public void h1() {

            }

            public void h2() {
                h3();
            }

            void h3() {
            }

        };
        hi.h1();
//        ((Hi) hi).h3(); h3在外部不可用，因为外部不可访问内部的方法，若需在外部使用，必须在接口中声明h3方法
        Aloha aloha = () -> {
        };
        JSONObject 哈哈 = new JSONObject();
        ((JSONObject) 哈哈).put("h1",1);
        ((JSONObject) 哈哈).put("h2","22");
        System.out.println(哈哈);
    }

    interface Hello {
        void helloo(String str);
    }

    interface Aloha {
        void a();
    }

    interface Hi {
        void h1();

        void h2();
    }

}
