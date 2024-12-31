package iih.bl.st.blpaypatoep.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PayDirectEnum {

    @DmEnumDesc(name="收款",description="charge")
	public static final Integer CHARGE=1; //收款
    @DmEnumDesc(name="找零",description="change")
	public static final Integer CHANGE=-1; //找零
}	
