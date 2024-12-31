package iih.en.pv.inpatient.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface OutWayEnum {

    @DmEnumDesc(name="走",description="走")
    public static final String WALK="0"; //走
    @DmEnumDesc(name="坐",description="坐")
    public static final String SIT="1"; //坐
    @DmEnumDesc(name="卧",description="卧")
    public static final String SLEEP="2"; //卧
}	
