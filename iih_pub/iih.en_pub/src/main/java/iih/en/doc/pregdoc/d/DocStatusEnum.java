package iih.en.doc.pregdoc.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface DocStatusEnum {

    @DmEnumDesc(name="预约",description="预约")
	public static final Integer EU_STATUS_APPT=1; //预约
    @DmEnumDesc(name="建档",description="建档")
	public static final Integer EU_STATUS_REG=2; //建档
    @DmEnumDesc(name="完成",description="完成")
	public static final Integer EU_STATUS_FIN=3; //完成
    @DmEnumDesc(name="取消",description="取消")
	public static final Integer EU_STATUS_CANC=4; //取消
}	
