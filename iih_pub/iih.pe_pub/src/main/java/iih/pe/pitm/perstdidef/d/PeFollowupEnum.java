package iih.pe.pitm.perstdidef.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PeFollowupEnum {

    @DmEnumDesc(name="无",description="无")
	public static final Integer PEFOLNO=0; //无
    @DmEnumDesc(name="普通",description="普通")
	public static final Integer PEFOLGEN=1; //普通
    @DmEnumDesc(name="重大",description="重大")
	public static final Integer PEFOLIM=2; //重大
    @DmEnumDesc(name="紧急",description="紧急")
	public static final Integer PEFOLEM=3; //紧急
}	
