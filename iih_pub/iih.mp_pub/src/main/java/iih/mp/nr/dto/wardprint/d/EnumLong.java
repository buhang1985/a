package iih.mp.nr.dto.wardprint.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EnumLong {

    @DmEnumDesc(name="全部",description="全部")
	public static final Integer ALL=0; //全部
    @DmEnumDesc(name="长期",description="长期")
	public static final Integer LONG=1; //长期
    @DmEnumDesc(name="临时",description="临时")
	public static final Integer TEMPORARY=2; //临时
}	
