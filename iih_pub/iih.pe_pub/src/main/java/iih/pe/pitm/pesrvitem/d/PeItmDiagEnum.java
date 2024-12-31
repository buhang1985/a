package iih.pe.pitm.pesrvitem.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PeItmDiagEnum {

    @DmEnumDesc(name="小项标识",description="小项标识")
	public static final Integer PEITMFLAG=1; //小项标识
    @DmEnumDesc(name="诊断分组标识",description="诊断分组标识")
	public static final Integer PEITMDIAGFLAG=2; //诊断分组标识
    @DmEnumDesc(name="总检专用",description="总检专用")
	public static final Integer PEITMOVAL=3; //总检专用
}	
