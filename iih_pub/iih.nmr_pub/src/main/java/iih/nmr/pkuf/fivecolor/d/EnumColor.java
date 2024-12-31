package iih.nmr.pkuf.fivecolor.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EnumColor {

    @DmEnumDesc(name="全部",description="")
	public static final Integer ALL=5; //全部
    @DmEnumDesc(name="绿色",description="")
	public static final Integer GREEN=0; //绿色
    @DmEnumDesc(name="黄色",description="")
	public static final Integer YELLOW=1; //黄色
    @DmEnumDesc(name="橙色",description="")
	public static final Integer ORANGE=2; //橙色
    @DmEnumDesc(name="红色",description="")
	public static final Integer RED=3; //红色
    @DmEnumDesc(name="紫色",description="")
	public static final Integer PURPLE=4; //紫色
}	
