package iih.pe.pitm.perules.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PeRuleRelationEnum {

    @DmEnumDesc(name="排除",description="排除")
	public static final Integer PERULEINCLUDE=1; //排除
    @DmEnumDesc(name="包含",description="包含")
	public static final Integer PERULEEXCLUDE=2; //包含
}	
