package iih.mi.biz.dto.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface MiFlowType {

    @DmEnumDesc(name="医保前置流程",description="医保前置流程")
    public static final String PREFLOW="0"; //医保前置流程
    @DmEnumDesc(name="常规流程",description="常规流程")
    public static final String NORMALFLOW="1"; //常规流程
}	
