package iih.pe.papt.pehmappt.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PeHmStatusEnum {

    @DmEnumDesc(name="取消预约",description="取消预约")
	public static final Integer PEHMAPPT=0; //取消预约
    @DmEnumDesc(name="预约",description="预约")
	public static final Integer PEHMAPPTED=1; //预约
    @DmEnumDesc(name="已登记",description="已登记")
	public static final Integer PEHMREGED=2; //已登记
    @DmEnumDesc(name="检查中",description="检查中")
	public static final Integer PEHMCHECKING=3; //检查中
    @DmEnumDesc(name="检查完成",description="检查完成")
	public static final Integer PEHMFINISHED=4; //检查完成
    @DmEnumDesc(name="报告打印",description="报告打印")
	public static final Integer PEHMPRINTED=5; //报告打印
    @DmEnumDesc(name="报告发放",description="报告发放")
	public static final Integer PEHMRELEASED=6; //报告发放
}	
