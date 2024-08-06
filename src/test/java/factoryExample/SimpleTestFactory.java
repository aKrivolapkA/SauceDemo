package factoryExample;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;


public class SimpleTestFactory {
    @Factory
    public Object[] factoryMethod() {
        return new Object[]{
                new SimpleTest("Test1"), //запустили все методы которые есть в клаасе
                new SimpleTest("Test2"),
                new SimpleTest("Test3")

        };
    }

  @Test
  public void runAllTests(){
        Object[]tests =factoryMethod(); //собрали в обект
      System.out.println("This is method 3 again");
      for(Object test : tests){ // прошлись по массиву
          ((SimpleTest)test).testMethod3();//преобразовали к типу и вызвали тест 3
      }
  }

}
