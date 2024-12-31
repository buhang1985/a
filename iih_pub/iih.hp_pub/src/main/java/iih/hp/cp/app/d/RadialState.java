package iih.hp.cp.app.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface RadialState {

    @DmEnumDesc(name="在径",description="")
	public static final Integer HP_CPAPP_RADIA_IN=1; //在径
    @DmEnumDesc(name="变异退出",description="")
	public static final Integer HP_CPAPP_RADIA_VAROUT=2; //变异退出
    @DmEnumDesc(name="正常退出",description="")
	public static final Integer HP_CPAPP_RADIA_NOROUT=3; //正常退出
    @DmEnumDesc(name="不使用",description="")
	public static final Integer HP_CPAPP_RADIA_NO=4; //不使用
}	
