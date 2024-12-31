package iih.nm.nom.nomnurplsm.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PlSmEnum {

    @DmEnumDesc(name="计划",description="")
	public static final Integer PLAN=0; //计划
    @DmEnumDesc(name="总结",description="")
	public static final Integer SUMMARY=1; //总结
}	
