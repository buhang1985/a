package iih.sc.apt.dto.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EuAptStatus {

    @DmEnumDesc(name="未预约",description="")
    public static final String UNAPTED="N"; //未预约
    @DmEnumDesc(name="已预约",description="")
    public static final String APTED="Y"; //已预约
    @DmEnumDesc(name="全部",description="")
    public static final String ALL="2"; //全部
}	
