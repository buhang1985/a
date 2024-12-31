package iih.bd.mhi.docenum.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface ChargeItemLevel {

    @DmEnumDesc(name="甲类",description="甲类")
    public static final String A="1"; //甲类
    @DmEnumDesc(name="乙类",description="乙类")
    public static final String B="2"; //乙类
    @DmEnumDesc(name="自费",description="自费")
    public static final String OWNEXP="3"; //自费
}	
