package iih.mp.dg.ipshetp.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface MpCabinetEnum {

    @DmEnumDesc(name="无智能柜",description="")
	public static final Integer NOSMART=0; //无智能柜
    @DmEnumDesc(name="智能柜药品 ",description="")
	public static final Integer SMART=1; //智能柜药品 
    @DmEnumDesc(name="非智能柜药品",description="")
	public static final Integer NOTSMART=2; //非智能柜药品
}	
