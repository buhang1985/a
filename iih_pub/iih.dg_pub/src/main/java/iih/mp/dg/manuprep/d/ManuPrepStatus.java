package iih.mp.dg.manuprep.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface ManuPrepStatus {

    @DmEnumDesc(name="未摆药",description="未摆药")
	public static final Integer STATUS_NOT=0; //未摆药
    @DmEnumDesc(name="摆药完成 ",description="摆药完成 ")
	public static final Integer STATUS_OVER=1; //摆药完成 
    @DmEnumDesc(name="取消摆药",description="取消摆药")
	public static final Integer STATUS_CANCEL=2; //取消摆药
}	
