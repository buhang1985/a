package iih.mp.ot.dto.phmyqry.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EnumDg {

    @DmEnumDesc(name="西药",description="")
	public static final Integer WESTERNDG=101; //西药
    @DmEnumDesc(name="中成药",description="")
	public static final Integer CHINESEPATDG=102; //中成药
    @DmEnumDesc(name="中草药",description="")
	public static final Integer CHINESEHERBDG=103; //中草药
}	
