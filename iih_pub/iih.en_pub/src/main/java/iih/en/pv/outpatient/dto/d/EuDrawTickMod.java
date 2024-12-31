package iih.en.pv.outpatient.dto.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EuDrawTickMod {

    @DmEnumDesc(name="退号",description="")
    public static final String DRAWBACK="0"; //退号
    @DmEnumDesc(name="作废",description="")
    public static final String REVOKE="1"; //作废
}	
