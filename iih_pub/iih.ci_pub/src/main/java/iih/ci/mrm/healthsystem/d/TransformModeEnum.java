package iih.ci.mrm.healthsystem.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface TransformModeEnum {

    @DmEnumDesc(name="无转换",description="无转换")
    public static final String NOTRANSFORM="0"; //无转换
    @DmEnumDesc(name="值对照",description="值对照")
    public static final String VALUECONTRAST="1"; //值对照
    @DmEnumDesc(name="脚本",description="脚本")
    public static final String SCRIPT="2"; //脚本
}	
