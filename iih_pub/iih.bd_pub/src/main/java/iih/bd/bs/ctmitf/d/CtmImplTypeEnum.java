package iih.bd.bs.ctmitf.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface CtmImplTypeEnum {

    @DmEnumDesc(name="实现类",description="")
    public static final String IMPLCLASS="1"; //实现类
    @DmEnumDesc(name="工厂类",description="")
    public static final String FACTORYCLASS="2"; //工厂类
}	
