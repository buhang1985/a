package iih.bd.srv.diagcatectm.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface CaOrDi {

    @DmEnumDesc(name="诊断",description="")
    public static final String DI="1"; //诊断
    @DmEnumDesc(name="分类",description="")
    public static final String CA="0"; //分类
}	
