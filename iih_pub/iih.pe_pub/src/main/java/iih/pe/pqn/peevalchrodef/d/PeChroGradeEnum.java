package iih.pe.pqn.peevalchrodef.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PeChroGradeEnum {

    @DmEnumDesc(name="低风险",description="低风险")
	public static final Integer PECHRORISKLOW=1; //低风险
    @DmEnumDesc(name="中度风险",description="中度风险")
	public static final Integer PECHRORISKMODERATE=2; //中度风险
    @DmEnumDesc(name="高风险",description="高风险")
	public static final Integer PECHRORISKHIGH=3; //高风险
}	
