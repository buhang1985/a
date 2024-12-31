package iih.en.pv.dto.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EnLvDepCheckTpEnum {

    @DmEnumDesc(name="医嘱检查",description="医嘱检查")
    public static final String CHECK_OR="01"; //医嘱检查
    @DmEnumDesc(name="执行检查",description="执行检查")
    public static final String CHECK_MP="02"; //执行检查
    @DmEnumDesc(name="药品检查",description="药品检查")
    public static final String CHECK_MM="03"; //药品检查
    @DmEnumDesc(name="医技检查",description="医技检查")
    public static final String CHECK_MT="04"; //医技检查
    @DmEnumDesc(name="费用检查",description="费用检查")
    public static final String CHECK_BL="05"; //费用检查
    @DmEnumDesc(name="其他检查",description="其他检查")
    public static final String CHECK_OTHER="06"; //其他检查
}	
