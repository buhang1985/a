package iih.mp.mpbd.patvstagt.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EnumRange {

    @DmEnumDesc(name="入院以来",description="入院以来")
	public static final Integer NULL=0; //入院以来
    @DmEnumDesc(name="指定范围",description="指定范围")
	public static final Integer RANGE=1; //指定范围
}	
