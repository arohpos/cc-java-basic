package main.chap14;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		
		//日付クラス使用例
		System.out.println("---日付クラス使用---");
		long now = System.currentTimeMillis();
		Date bfDate = new Date(now);
		System.out.println(bfDate);
		bfDate = new Date();
		System.out.println(bfDate);
		System.out.println(bfDate.getTime());
		
		//DateからStringへの変換
		System.out.println("---DateからStringへの変換---");
		SimpleDateFormat dateToStringFormat = new SimpleDateFormat("yyyy/MM/dd");
		String afString = dateToStringFormat.format(bfDate);
		System.out.println(afString);
		
		//StringからDateへの変換
		try {
			System.out.println("---StringからDateへの変換---");
			String str = "2022/01/01";
			SimpleDateFormat stringToDateFormat = new SimpleDateFormat("yyyy/MM/dd");
			Date afDate  = stringToDateFormat.parse(str);
			System.out.println(afDate);
			
		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		//カレンダークラス使用例		
		System.out.println("---カレンダークラス使用---");
		Calendar cl = Calendar.getInstance();
		int year = cl.get(Calendar.YEAR);
		int month = cl.get(Calendar.MONTH);
		int day = cl.get(Calendar.DATE);
		int day_of_year = cl.get(Calendar.DAY_OF_YEAR);
		System.out.println(year);
		System.out.println(month);
		System.out.println(day);
		System.out.println(day_of_year);

	}

}
