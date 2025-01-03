package iih.pe.pwf.pewfoval.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PeRptReleWayEnum {

    @DmEnumDesc(name="自取",description="自取")
	public static final Integer PERPTRELESELF=1; //自取
    @DmEnumDesc(name="代领",description="代领")
	public static final Integer PERPTRELEBAILE=2; //代领
    @DmEnumDesc(name="团体集中领取",description="团体集中领取")
	public static final Integer PERPTRELECORP=3; //团体集中领取
    @DmEnumDesc(name="邮寄",description="邮寄")
	public static final Integer PERPTRELEPOST=4; //邮寄
}	
