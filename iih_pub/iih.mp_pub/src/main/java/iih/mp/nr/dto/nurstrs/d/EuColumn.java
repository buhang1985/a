package iih.mp.nr.dto.nurstrs.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EuColumn {

    @DmEnumDesc(name="左",description="左")
	public static final Integer LEFT=0; //左
    @DmEnumDesc(name="中",description="中")
	public static final Integer CENTER=1; //中
    @DmEnumDesc(name="右",description="右")
	public static final Integer RIGHT=2; //右
}	
