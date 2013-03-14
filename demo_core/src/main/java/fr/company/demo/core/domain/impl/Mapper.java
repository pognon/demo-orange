package fr.company.demo.core.domain.impl;

import fr.company.demo.data.entity.DemoEntity;


public class Mapper {
	
	public static DemoBean transformEntityToBean(DemoEntity entity){
		return new DemoBean();
	}
	
	public static DemoEntity transformBeanToEntity(DemoBean bean){
		
		return null;
		
	}

}
