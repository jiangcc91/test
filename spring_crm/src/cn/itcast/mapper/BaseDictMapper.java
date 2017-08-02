package cn.itcast.mapper;

import java.util.List;

import cn.itcast.domain.BaseDict;

public interface BaseDictMapper {

	List<BaseDict> getPreList(String source);

}
