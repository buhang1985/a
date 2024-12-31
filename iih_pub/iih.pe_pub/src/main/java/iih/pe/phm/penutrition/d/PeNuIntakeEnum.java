package iih.pe.phm.penutrition.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PeNuIntakeEnum {

    @DmEnumDesc(name="不足",description="不足")
	public static final Integer PENUINTAKELESS=1; //不足
    @DmEnumDesc(name="适当",description="适当")
	public static final Integer PENUINTAKERIGHT=2; //适当
    @DmEnumDesc(name="过量",description="过量")
	public static final Integer PENUINTAKEOVER=3; //过量
}	
