package iih.en.er.pre.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EuEqidemic {

    @DmEnumDesc(name="未知",description="未知")
    public static final String UNKNOWN="0"; //未知
    @DmEnumDesc(name="有",description="有")
    public static final String HAVE="1"; //有
    @DmEnumDesc(name="无",description="无")
    public static final String NOHAVE="2"; //无
}	
