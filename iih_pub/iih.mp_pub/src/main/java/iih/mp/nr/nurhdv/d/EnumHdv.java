package iih.mp.nr.nurhdv.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EnumHdv {

    @DmEnumDesc(name="白班",description="白班")
	public static final Integer DAY=0; //白班
    @DmEnumDesc(name="小夜",description="小夜")
	public static final Integer SDAY=1; //小夜
    @DmEnumDesc(name="大夜",description="大夜")
	public static final Integer LDAY=2; //大夜
}	
