package iih.pe.pitm.perules.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PeRuleItemRstTpEnum {

    @DmEnumDesc(name="检查结果",description="根据结果")
	public static final Integer PERULEITEMRESULT=1; //检查结果
    @DmEnumDesc(name="异常标识",description="根据异常标识")
	public static final Integer PERULEITEMMARK=2; //异常标识
    @DmEnumDesc(name="诊断",description="根据诊断")
	public static final Integer PERULEITEMDIAG=3; //诊断
}	
