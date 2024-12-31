package iih.bd.srv.ems.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PresPrnRelFactorEnum {

    @DmEnumDesc(name="处方类型",description="处方类型")
    public static final String PRESTYPE="1"; //处方类型
    @DmEnumDesc(name="处方标识类型",description="处方标识类型")
    public static final String PRESFLAGTYPE="2"; //处方标识类型
}	
