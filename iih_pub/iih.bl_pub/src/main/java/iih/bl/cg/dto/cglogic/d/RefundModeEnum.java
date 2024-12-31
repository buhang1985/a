package iih.bl.cg.dto.cglogic.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface RefundModeEnum {

    @DmEnumDesc(name="记账主键",description="")
    public static final String CG_KEY="1"; //记账主键
    @DmEnumDesc(name="执行计划主键",description="")
    public static final String PRSRV_KEY="2"; //执行计划主键
    @DmEnumDesc(name="医嘱服务主键",description="")
    public static final String ORSRV_KEY="3"; //医嘱服务主键
    @DmEnumDesc(name="挂起记账主键",description="")
    public static final String SUSP_KEY="4"; //挂起记账主键
}	
