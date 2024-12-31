package iih.mp.nr.vitalsigns.dto.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EnumDataTp {

    @DmEnumDesc(name="字符串",description="字符串")
	public static final Integer STRING=1; //字符串
    @DmEnumDesc(name="整数值",description="整数值")
	public static final Integer INT=2; //整数值
    @DmEnumDesc(name="小数值",description="小数值")
	public static final Integer DECIMAL=3; //小数值
}	
