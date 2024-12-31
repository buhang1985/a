package iih.mi.mc.mimctactics.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface MiMcTacticsEnum {

    @DmEnumDesc(name="诊断依赖判断类型",description="诊断依赖判断类型")
	public static final Integer DIAGDEP=1; //诊断依赖判断类型
    @DmEnumDesc(name="诊断范围判断类型",description="诊断范围判断类型")
	public static final Integer DIAGSCOPE=2; //诊断范围判断类型
    @DmEnumDesc(name="医保适应症接口类型",description="医保适应症接口类型")
	public static final Integer HPFIT=3; //医保适应症接口类型
    @DmEnumDesc(name="医保开单整体校验接口类型",description="医保开单整体校验接口类型")
	public static final Integer HPBILLCHECK=4; //医保开单整体校验接口类型
    @DmEnumDesc(name="外挂插件类型",description="外挂插件类型")
	public static final Integer PLUGIN=5; //外挂插件类型
}	
