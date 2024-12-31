package iih.bl.cg.dto.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface NurseTPOrderCGModeEnum {

    @DmEnumDesc(name="按天计（在前优先）",description="按开始时间在前的医嘱价格记账")
	public static final String FRONT="11";
    @DmEnumDesc(name="按天计（在后优先）",description="按开始时间在后的医嘱价格记账")
	public static final String BACK="12";
    @DmEnumDesc(name="按天计（价高优先）",description="按价格最高的医嘱价格记账")
	public static final String HIGH="13";
    @DmEnumDesc(name="按天计（价低优先）",description="按价格最低的医嘱价格记账")
	public static final String LOW="14";
    @DmEnumDesc(name="按秒计",description="按秒记费")
	public static final String SECOND="21";
}	
