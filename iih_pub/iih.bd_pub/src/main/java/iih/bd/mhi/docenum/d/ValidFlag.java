package iih.bd.mhi.docenum.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface ValidFlag {

    @DmEnumDesc(name="无效",description="无效")
    public static final String INVALID="0"; //无效
    @DmEnumDesc(name="有效",description="有效")
    public static final String VALID="1"; //有效
}	
