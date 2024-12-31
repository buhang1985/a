package iih.bd.fc.orwf.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EnumLong {

    @DmEnumDesc(name="-",description="不限制")
	public static final Integer NULL=2; //-
    @DmEnumDesc(name="长期",description="长期")
	public static final Integer LONG=1; //长期
    @DmEnumDesc(name="临时",description="临时")
	public static final Integer TEMP=0; //临时
}	
