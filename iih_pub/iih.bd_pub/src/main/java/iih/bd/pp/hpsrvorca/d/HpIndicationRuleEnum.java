package iih.bd.pp.hpsrvorca.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface HpIndicationRuleEnum {

    @DmEnumDesc(name="不控制",description="NO_CONTROL")
    public static final String NO_CONTROL="01"; //不控制
    @DmEnumDesc(name="系统判断医生确认",description="SYS_JUD_DOCCONFIRM")
    public static final String SYS_JUD_DOCCONFIRM="12"; //系统判断医生确认
    @DmEnumDesc(name="医生判断及确认",description="DOC_CONFIRM")
    public static final String DOC_CONFIRM="21"; //医生判断及确认
}	
