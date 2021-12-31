//오버라이딩 연습
//public class는 파일 하나당 한번만 쓸수있음
package com.javaex.ex08;


class Vo {
	
	public void info() {
		System.out.println("");
	}
	
}

class App extends Vo{
	
	public void info() {
		System.out.println("");
	}
}

public class Overriding{
	
	public static void main(String[] args) {
		
		Vo name = new Vo();
		name.info();
	}
	
}
