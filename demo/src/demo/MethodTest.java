package demo;

import java.util.Arrays;
import java.util.List;

/**
 * 方法引用测试
 * @author wwy
 * @ClassName demo.MethodTest.java
 * @date 2020年1月15日  上午9:51:02
 * @version v0.0.1
 *
 */
public class MethodTest {
public static void main(String[] args) {
	//1、新建两个AA对象，放到ArrayList中
	List<AA> list=Arrays.asList(new AA(),new AA());
	//遍历list，并将所有的AA对象name修改成“一条狗”
	list.forEach(AA::updateName);
	//遍历list，并将所有的AA对象age修改成18
	list.forEach(AA::aupdateAge);
	//遍历集合，打印内容
	list.forEach(System.out::println);
}
}

class AA{
	private int age;
	private String name;
	
	@Override
	public String toString() {
		return "AA [age=" + age + ", name=" + name + "]";
	}

	public int getAge() {
		return this.age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	//将对象的name改为一条狗
	public  void updateName() {
		this.name="一条狗";
	}
	//根据传递的AA对象修改对象的age值
	public  static void aupdateAge(AA aa) {
		aa.setAge(18);
	}

}