package iih.bd.pp.anhuiinsur.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface BedGrade {

    @DmEnumDesc(name="普通病床",description="普通病床")
    public static final String NORMALBED="1"; //普通病床
    @DmEnumDesc(name="CCU病床",description="CCU病床")
    public static final String CCUBED="2"; //CCU病床
    @DmEnumDesc(name="ICU病床",description="ICU病床")
    public static final String ICUBED="3"; //ICU病床
    @DmEnumDesc(name="麻醉病床",description="麻醉病床")
    public static final String ANESTHESIABED="4"; //麻醉病床
}	
