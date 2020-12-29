package app;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import dto.JoinDto;
import dto.LoginDto;

public class ReflectApp {

	static <T> void myReflect(T dto) {		//제네릭 선언(모든타입이 다 가능)

		Method[] methods = dto.getClass().getMethods();
		for(Method method:methods) {//methods의 크기만큼
			if(method.getName().equals("setPassword")) {
				
			}
		}				//한개가아니라 배열로 받음
		
		Field[] fs = dto.getClass().getDeclaredFields();
		
		for(Field f : fs) {
			f.setAccessible(true);
			try {
				if(f.getName().equals("password")) {
					f.set(dto, "5678");
				}
				Object o = f.get(dto);
				System.out.println(o);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		LoginDto loginDto = new LoginDto();
		loginDto.setUsername("ssar");
		loginDto.setPassword("1234");
		
		JoinDto joinDto = new JoinDto();
		joinDto.setUsername("ssar");
		joinDto.setPassword("1234");
		joinDto.setEmail("ssar@nate.com");
		
		myReflect(joinDto);
	
		
	}
}
