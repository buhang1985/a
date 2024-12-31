package iih.sc.apt.dto.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EuTimeTp {

    @DmEnumDesc(name="申请时间",description="")
    public static final String APPLY="1"; //申请时间
    @DmEnumDesc(name="计划时间",description="")
    public static final String PLAN="2"; //计划时间
}	
