package main.chap13;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("それぞれのクラスで操作を行う場合");
		
		Point p = new Point(1, 2);
		System.out.println(p.toString());
		
		Line line  = new Line(1, 2, 4, 6);
		line.draw();
		System.out.println(line.perimeter());
		
		Circle circle = new Circle(1, 1, 2);
		circle.draw();
		System.out.println(circle.perimeter());
		
		Triangle triangle = new Triangle(1, 2, 3, 4, 5, 6);
		triangle.draw();
		System.out.println(triangle.perimeter());
		System.out.println(triangle.getInternalAngle());
		
		Rectangle rectangle = new Rectangle(1, 2, 3, 4);
		rectangle.draw();
		System.out.println(rectangle.perimeter());
		System.out.println(rectangle.getInternalAngle());
		
		Square square = new Square(1, 2, 3);
		square.draw();
		System.out.println(square.perimeter());
		System.out.println(square.getInternalAngle());

		System.out.println("ポリモーフィズムを用いて処理を記載する場合");
		System.out.println("図形描画[0:円/2:線/3:三角形/4:長方形/44:正方形]");
		Scanner sc = new Scanner(System.in);
		int userRequest = sc.nextInt();
		//ここで初期化しないとエラーになる。
		Figure figure = null;
		//スイッチ文内でアップキャスト
		switch(userRequest) {
			case 0:{
				System.out.println("円の生成に必要情報を入力してください。[中心点（x座標）・中心点（y座標）・半径]");
				figure = new Circle(sc.nextInt(), sc.nextInt(), sc.nextInt());
				break;
				}
			case 2: {
				System.out.println("線の生成に必要情報を入力してください。[始点（x座標）・始点（y座標）・終点（x座標）・終点（y座標）]");
				figure = new Line(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
				break;
			}
			case 3:{
				System.out.println("三角形の生成に必要情報を入力してください。[点1（x座標）・点2（y座標）・点2（x座標）・点2（y座標）・点3（ｘ座標）・点3（ｙ座標）]");
				figure = new Triangle(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
				break;
			}
			case 4:{
				System.out.println("長方形の生成に必要情報を入力してください。[基準点（x座標）・基準点（y座標）・幅・高さ]");
				figure =new Rectangle(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
				break;
			}
			case 44:{
				System.out.println("正方形の生成に必要情報を入力してください。[基準点（x座標）・基準点（y座標）・幅]");
				figure = new Square(sc.nextInt(), sc.nextInt(), sc.nextInt());
				break;
			}
		}
		figure.draw();
		System.out.println(figure.perimeter());
		
		//Polygonにダウンキャストして内角の和を出力
		if(figure instanceof Polygon) {
			Polygon polygon = (Polygon)figure;
			System.out.println("クラスがPolygonです。");
			System.out.println("内角の和：" + polygon.getInternalAngle());
		}

	}

}
