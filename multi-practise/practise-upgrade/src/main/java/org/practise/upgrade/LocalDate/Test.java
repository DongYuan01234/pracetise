package org.practise.upgrade.LocalDate;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
		//获取当前日期
		LocalDate today  = LocalDate.now();
		System.out.println(today);
		// 根据年月日取日期，12月就是12：
		LocalDate crischristmas = LocalDate.of(2014, 12, 25); // -> 2014-12-25
		System.out.println(crischristmas);
		// 根据字符串取：
		LocalDate endOfFeb = LocalDate.parse("2014-02-28"); // 严格按照ISO yyyy-MM-dd验证，02写成2都不行，当然也有一个重载方法允许自己定义格式
		System.out.println(endOfFeb);
		//LocalDate.parse("2014-02-29"); // 无效日期无法通过：DateTimeParseException: Invalid date
		
		System.out.println("--------------LocalTime----------------");
		// 取本月第1天：
		LocalDate firstDayOfThisMonth = today.with(TemporalAdjusters.firstDayOfMonth()); // 2014-12-01
		System.out.println(firstDayOfThisMonth);
		// 取本月第2天：
		LocalDate secondDayOfThisMonth = today.withDayOfMonth(2); // 2014-12-02
		System.out.println(secondDayOfThisMonth);
		// 取本月最后一天，再也不用计算是28，29，30还是31：
		LocalDate lastDayOfThisMonth = today.with(TemporalAdjusters.lastDayOfMonth()); // 2014-12-31
		System.out.println("本月最后一天"+lastDayOfThisMonth);
		// 取下一天：
		LocalDate firstDayOf2015 = lastDayOfThisMonth.plusDays(1); // 变成了2015-01-01
		System.out.println("取下一天"+firstDayOf2015);
		// 取2015年1月第一个周一，这个计算用Calendar要死掉很多脑细胞：
		LocalDate firstMondayOf2015 = LocalDate.parse("2015-01-01").with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)); // 2015-01-05
		System.out.println("2015年1月第一个周一"+firstDayOf2015);
		
		
		System.out.println("-------localtime----------");
		LocalTime now = LocalTime.now();
		System.out.println(now);
		System.out.println("--------------------------");
		LocalTime nowNoNano = LocalTime.now().withNano(0);
		System.out.println(nowNoNano);
		//构造时间
		LocalTime zero = LocalTime.of(0, 0, 0); // 00:00:00
		System.out.println(zero);
		LocalTime mid = LocalTime.parse("12:00:00"); // 12:00:00
		System.out.println(mid);
		
		System.out.println("----------------localDateTime---------------------");
		ZoneId zoneId = ZoneId.systemDefault();
		LocalDateTime todayStart=LocalDateTime.now().minusDays(30).withHour(0).withMinute(0).withSecond(0).withNano(0);
		ZonedDateTime zdt = todayStart.atZone(zoneId);
		Date date = Date.from(zdt.toInstant());
		
		System.out.println(date);
		
		
	}
}
