package demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 流式操作demo
 * @author wwy
 * @ClassName demo.StreamTest.java
 * @date 2020年1月15日  上午10:27:39
 * @version v0.0.1
 *
 */
public class StreamTest {
	public static void main(String[] args) {
		/////////////////遍历//////////////////////
		//新建一个List,存放BB对象
		List<BB> list=Arrays.asList(new BB("张三",18,"男"),new BB("李四",19,"女"),new BB("王二",20,"女"),null,new BB("麻子",21,"男"));
		//流失操作返回的Stream对象
		Stream<BB> stream = list.stream();
		//遍历打印
		list.forEach(System.out::println);
		System.out.println("========================");
		//将list调用stream转换成流后进行过滤,去除空值，遍历
		list.stream().filter(Objects::nonNull).forEach(System.out::println);
		//将list调用stream转换成流后进行过滤,去除空值,并按照性别分组，返回一个map集合
		System.out.println("========================");
		Map<String, List<BB>> collect = list.stream().filter(Objects::nonNull).collect(Collectors.groupingBy(BB::getSex));
		//用流失操作遍历set集合
		collect.keySet().stream().forEach(System.out::println);		
		//将list调用stream转换成流后进行过滤,去除空值,并筛选出年龄<=19的进行遍历
		System.out.println("========================");
		list.stream().filter(Objects::nonNull).filter(s->(s.getAge()<=19)).forEach(System.out::println);;
		//将所有的姓名组成一个新的list集合
		System.out.println("========================");
		list.stream().filter(Objects::nonNull).map(BB::getName).collect(Collectors.toList()).forEach(System.out::println);
		/////////////////////判断/////////////////////////////////////
		//判断是否所有学生都大于18岁
		System.out.println("========================");
		boolean b = list.stream().filter(Objects::nonNull).allMatch(a->a.getAge()>=18);
		System.out.println(b);
		//找到第一个满足条件的对象
		System.out.println("========================");
		BB bb = list.stream().filter(Objects::nonNull).filter(a->a.getName().equals("张三")).findFirst().get();
		System.out.println(bb);
		
		
	}

	
}


/**
 * 自定义BB类
 * @author wwy
 * @ClassName demo.StreamTest.java
 * @date 2020年1月15日  上午10:28:33
 * @version v0.0.1
 *
 */
class BB {
	private int age;
	private String name;
	private String sex;
	public BB(String name,int age,String sex) {
		super();
		this.age = age;
		this.name = name;
		this.sex=sex;
	}

	public BB() {
		super();
	}
	@Override
	public String toString() {
		return "BB [age=" + age + ", name=" + name + ", sex=" + sex + "]";
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
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
}