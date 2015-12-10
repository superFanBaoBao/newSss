package main.main.util.gson;

import main.main.util.gson.entity.Common;
import main.main.util.gson.entity.CommonList;
import main.main.util.gson.entity.FromJsonUtils;
import main.main.util.gson.entity.Person;
import main.main.util.gson.entity.User;


public class Test {

	public static void main(String[] args) {
		String json1="{\"status\":\"ok\",\"message\":\"登陆成功\",\"data\":\"\"}";
		Common result=new FromJsonUtils(Object.class, json1).fromJson();
		System.out.println("state:"+result.getStatus()+"        message:"+result.getMessage());
		 json1="{\"status\":\"ok\",\"message\":\"登陆成功\",\"data\":{\"id\":\"1\",\"age\":\"15\",\"sex\":\"女\"}}";
		 Common<User> result1=new FromJsonUtils(User.class, json1).fromJson();
		 System.out.println("state:"+result1.getStatus()+"        message:"+result1.getMessage()+"data:"+"sex>"+result1.getData().getSex());
		 json1="{\"status\":\"ok\",\"message\":\"登陆成功\",\"data\":{\"name\":\"吕小芳\",\"user\":{\"id\":\"1\",\"age\":\"15\",\"sex\":\"女\"}}}";
		 Common<Person> result2=new FromJsonUtils(Person.class, json1).fromJson();
		 System.out.println("state:"+result2.getStatus()+"        message:"+result2.getMessage()+"data:"+"name>"+result2.getData().getName()+"      sex>"+result2.getData().getUser().getSex());
		 json1="{\"status\":\"ok\",\"message\":\"登陆成功\",\"data\":{\"name\":\"吕小芳\",\"list\":[{\"id\":\"1\",\"age\":\"15\",\"sex\":\"女\"},{\"id\":\"1\",\"age\":\"15\",\"sex\":\"男\"}]}}";
		 Common<Person> result3=new FromJsonUtils(Person.class, json1).fromJson();
		 System.out.println("state:"+result3.getStatus()+"        message:"+result3.getMessage()+"data:"+"name>"+result3.getData().getName()+"      sex>"+result3.getData().getList().get(1).getSex());
		 json1="{\"status\":\"ok\",\"message\":\"登陆成功\",\"data\":[{\"id\":\"1\",\"age\":\"15\",\"sex\":\"女\"},{\"id\":\"1\",\"age\":\"15\",\"sex\":\"男\"}]}";
		 CommonList<User> list=new FromJsonUtils(User.class, json1).fromJsonList();
		 System.out.println("data>>"+list.getData().toString());
	
	}
}