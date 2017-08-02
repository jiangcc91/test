package com.itheima.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateConverter implements Converter<String,Date>{

	@Override
	public Date convert(String source) {
		//实现字符串到日期格式的转换
		try {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	

}
