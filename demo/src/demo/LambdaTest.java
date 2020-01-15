package demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Lambda表达式的demo
 * @author wwy
 * @date 2020年1月7日
 * @version v0.0.1
 *
 */
public class LambdaTest {
	/////////////////需求////////////////////
	//首先我们自定义了一个函数式接口
	//接下来我们需要把这个接口的对象存放到ArrayList中
	public static void main(String[] args) {
		List<Lambda> list=new ArrayList<>();
		///////////////老方法实现////////////////////
		//1、定义匿名内部类，并重写抽象方法，返回一个接口对象
		Lambda l=new Lambda() {
			
			@Override
			public void aa() {
				System.out.println("aa");
				
			}
		};
	//2、将接口对象放入ArrayList中
		list.add(l);
		
	////////////////新方法//////////////////////
		list.add(()->System.out.println("aa"));
	}
	
	
}
/**
 * 自定义函数式接口
 * @author wwy
 * @ClassName demo.LambdaTest.java
 * @date 2020年1月15日  上午9:41:13
 * @version v0.0.1
 *
 */
@FunctionalInterface//此注解用于检测函数式接口
interface Lambda{
	void aa();
}