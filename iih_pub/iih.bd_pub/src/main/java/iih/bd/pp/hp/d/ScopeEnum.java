package iih.bd.pp.hp.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface ScopeEnum {

    @DmEnumDesc(name="全局选择",description="全局选择")
	public static final Integer OVERALL=0; //全局选择
    @DmEnumDesc(name="患者被医院授权后选择",description="患者被医院授权后选择")
	public static final Integer HOSPITALAUTH=1; //患者被医院授权后选择
}	
