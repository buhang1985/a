package iih.en.pv.dto.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EntQryRangeEnum {

    @DmEnumDesc(name="当前医生",description="当前医生")
    public static final String CUREMP="0"; //当前医生
    @DmEnumDesc(name="本科",description="本科")
    public static final String CURDEP="1"; //本科
    @DmEnumDesc(name="全院",description="全院")
    public static final String ALLHOS="2"; //全院
}	
