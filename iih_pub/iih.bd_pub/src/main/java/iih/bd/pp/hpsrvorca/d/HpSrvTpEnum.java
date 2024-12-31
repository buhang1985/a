package iih.bd.pp.hpsrvorca.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface HpSrvTpEnum {

    @DmEnumDesc(name="药品",description="DRUG")
	public static final Integer DRUG=1; //药品
    @DmEnumDesc(name="诊疗",description="ZL")
	public static final Integer ZL=2; //诊疗
    @DmEnumDesc(name="服务设施",description="FWSS")
	public static final Integer FWSS=3; //服务设施
    @DmEnumDesc(name="病种",description="DI")
	public static final Integer DI=4; //病种
}	
