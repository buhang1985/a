package iih.pe.papt.pepsnappt.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PeStatusEnum {

    @DmEnumDesc(name="预约",description="预约")
	public static final Integer PEAPPT=0; //预约
    @DmEnumDesc(name="已登记",description="已登记")
	public static final Integer PEAPPTED=1; //已登记
    @DmEnumDesc(name="已缴费",description="已缴费")
	public static final Integer PEREGED=2; //已缴费
    @DmEnumDesc(name="体检中",description="体检中")
	public static final Integer PECHECKING=3; //体检中
    @DmEnumDesc(name="体检完成",description="体检完成")
	public static final Integer PEFINISHED=4; //体检完成
    @DmEnumDesc(name="分检核对",description="分检核对")
	public static final Integer PEVERIFIED=5; //分检核对
    @DmEnumDesc(name="已总检",description="已总检")
	public static final Integer PEOVAL=6; //已总检
    @DmEnumDesc(name="总检已核",description="总检已核")
	public static final Integer PEOVALAUDI=7; //总检已核
    @DmEnumDesc(name="已打印",description="已打印")
	public static final Integer PEPRINTED=8; //已打印
    @DmEnumDesc(name="报告发放",description="报告发放")
	public static final Integer PERELEASED=9; //报告发放
    @DmEnumDesc(name="取消预约",description="取消预约")
	public static final Integer PECANCELED=-1; //取消预约
}	
