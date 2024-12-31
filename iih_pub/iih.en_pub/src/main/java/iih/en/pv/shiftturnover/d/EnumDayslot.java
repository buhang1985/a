package iih.en.pv.shiftturnover.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EnumDayslot {

    @DmEnumDesc(name="白班",description="白班")
    public static final String DAYSHIFT="0"; //白班
    @DmEnumDesc(name="晚班",description="晚班")
    public static final String NIGHTSHIFT="1"; //晚班
}	
