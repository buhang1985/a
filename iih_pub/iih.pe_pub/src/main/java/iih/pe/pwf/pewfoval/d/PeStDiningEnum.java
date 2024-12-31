package iih.pe.pwf.pewfoval.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PeStDiningEnum {

    @DmEnumDesc(name="未用餐",description="未用餐")
	public static final Integer PENONE=1; //未用餐
    @DmEnumDesc(name="正在用餐",description="正在用餐")
	public static final Integer PEDINING=2; //正在用餐
    @DmEnumDesc(name="用餐完毕",description="用餐完毕")
	public static final Integer PEDINNNGED=3; //用餐完毕
}	
