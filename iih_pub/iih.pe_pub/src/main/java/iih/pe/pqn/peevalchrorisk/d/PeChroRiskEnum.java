package iih.pe.pqn.peevalchrorisk.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PeChroRiskEnum {

    @DmEnumDesc(name="自身",description="自身")
	public static final Integer PECHRORISKSELF=1; //自身
    @DmEnumDesc(name="体检结果",description="体检结果")
	public static final Integer PECHRORISKRST=2; //体检结果
    @DmEnumDesc(name="问卷",description="问卷")
	public static final Integer PECHRORISKQA=3; //问卷
    @DmEnumDesc(name="诊断",description="诊断")
	public static final Integer PECHRORISKDI=4; //诊断
}	
