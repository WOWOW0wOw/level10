package _15함수형프로그래밍;

import java.util.function.BinaryOperator;

class Calculate {
	int add(int a, int b) {
		return a + b;
	}

	int subtract(int a, int b) {
		return a - b;
	}

	int multiply(int a, int b) {
		return a * b;
	}
}

interface CalFunction {
	int result(int a, int b);
}

public class _03함수형프로그래밍실습 {

	public static void main(String[] args) {

		Calculate cal = new Calculate();
		System.out.println(cal.add(10, 20));
		System.out.println(cal.subtract(10, 20));
		System.out.println(cal.multiply(10, 20));

		// 함수형 인터페이스 CalFunction 만들어서 위와 같은 결과 실행
		// 각각 인터페이스 변수 3개 Add, Subtract, Multiply 만들어서 위와 같은 결과 실행

		System.out.println("===================");

//		CalFunction Add = (int a, int b) -> System.out.printf("%d + %d = %d\n", a, b, a + b);
//		CalFunction Subtract = (int a, int b) -> System.out.printf("%d - %d = %d\n", a, b, a - b);
//		CalFunction Multiply = (int a, int b) -> System.out.printf("%d * %d = %d\n", a, b, a * b);

		CalFunction Add = (int a, int b) -> {
			return a + b;
		};
		CalFunction Subtract = (int a, int b) -> {
			return a - b;
		};
		CalFunction Multiply = (a, b) -> a * b;

		System.out.println(Add.result(10, 20));
		System.out.println(Subtract.result(10, 20));
		System.out.println(Multiply.result(10, 20));

		BinaryOperator<Integer> add2 = (a, b) -> a + b;
		System.out.println(add2.apply(10, 20));

	}

}
