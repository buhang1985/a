package iih.bl.cg.blcgquery.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface BookRtnDirectEnum {

    @DmEnumDesc(name="记费",description="charges")
	public static final Integer CHARGES=1; //记费
    @DmEnumDesc(name="退费",description="refund")
	public static final Integer REFUND=-1; //退费
}	
