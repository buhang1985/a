package iih.bd.pp.anhuiinsur.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface NeedApprovedFlag {

    @DmEnumDesc(name="不需要",description="不需要")
    public static final String NOTNEED="0"; //不需要
    @DmEnumDesc(name="需要",description="需要")
    public static final String NEED="1"; //需要
}	
