package iih.pi.dic.patcatehp.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface HpIdentityReadModeEnum {

    @DmEnumDesc(name="无卡读取",description="无卡读取")
    public static final String NO_CARD="1"; //无卡读取
    @DmEnumDesc(name="有卡读取",description="有卡读取")
    public static final String HAS_CARD="2"; //有卡读取
}	
