package iih.ci.tsip.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EuMpMdEnum {

    @DmEnumDesc(name="EN_IMPORT",description="就诊接口调用")
    public static final String EN_IMPORT="0"; //EN_IMPORT
    @DmEnumDesc(name="APP_IMPORT",description="导入功能操作")
    public static final String APP_IMPORT="1"; //APP_IMPORT
}	
