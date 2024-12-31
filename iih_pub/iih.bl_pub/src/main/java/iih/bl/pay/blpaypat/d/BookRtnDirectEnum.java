package iih.bl.pay.blpaypat.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface BookRtnDirectEnum {

    @DmEnumDesc(name="收费",description="charge")
	public static final Integer CHARGE=1; //收费
    @DmEnumDesc(name="退费",description="returns")
	public static final Integer RETURNS=-1; //退费
}	
