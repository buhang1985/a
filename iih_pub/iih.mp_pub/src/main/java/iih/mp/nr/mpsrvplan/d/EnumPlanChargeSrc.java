package iih.mp.nr.mpsrvplan.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EnumPlanChargeSrc {

    @DmEnumDesc(name="医嘱生成",description="医嘱生成")
	public static final Integer ORGRNT=0; //医嘱生成
    @DmEnumDesc(name="药房",description="药房")
	public static final Integer PHARMACY=1; //药房
    @DmEnumDesc(name="医技科室",description="医技科室")
	public static final Integer TECH=2; //医技科室
    @DmEnumDesc(name="医技补费",description="医技补费")
	public static final Integer TECHMEND=3; //医技补费
}	
