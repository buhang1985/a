package iih.bd.srv.mrelement.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface ActiveMethod {

    @DmEnumDesc(name="弹出",description="弹出")
	public static final Integer TYPE0=1; //弹出
    @DmEnumDesc(name="下拉 ",description="下拉 ")
	public static final Integer TYPE1=2; //下拉 
    @DmEnumDesc(name="平铺",description="平铺")
	public static final Integer TYPE2=3; //平铺
}	
