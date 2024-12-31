package iih.sc.sch.sctick.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EuUseState {

    @DmEnumDesc(name="未用",description="")
	public static final Integer WY=0; //未用
    @DmEnumDesc(name="使用",description="")
	public static final Integer SY=1; //使用
    @DmEnumDesc(name="取消使用",description="")
	public static final Integer QXSY=2; //取消使用
    @DmEnumDesc(name="占用",description="")
	public static final Integer OCCUPY=3; //占用
    @DmEnumDesc(name="保留",description="")
	public static final Integer HOLD=4; //保留
    @DmEnumDesc(name="过期",description="")
	public static final Integer GQ=5; //过期
    @DmEnumDesc(name="锁定",description="")
	public static final Integer LOCK=6; //锁定
}	
