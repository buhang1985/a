package iih.mc.st.inspection.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface McInspStEnum {

    @DmEnumDesc(name="已验收",description="")
	public static final Integer YS=0; //已验收
    @DmEnumDesc(name="已入库",description="")
	public static final Integer RK=1; //已入库
    @DmEnumDesc(name="已退库",description="")
	public static final Integer TK=2; //已退库
    @DmEnumDesc(name="入库中",description="")
	public static final Integer RKZ=3; //入库中
    @DmEnumDesc(name="退库中",description="")
	public static final Integer TKZ=4; //退库中
}	
