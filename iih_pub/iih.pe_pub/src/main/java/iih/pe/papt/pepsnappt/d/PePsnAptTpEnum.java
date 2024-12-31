package iih.pe.papt.pepsnappt.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PePsnAptTpEnum {

    @DmEnumDesc(name="正常体检预约",description="正常体检预约")
	public static final Integer PEPSNAPT=1; //正常体检预约
    @DmEnumDesc(name="补检预约",description="补检预约")
	public static final Integer PEPSNAPTRECHECK=2; //补检预约
    @DmEnumDesc(name="复查预约",description="复查预约")
	public static final Integer PEPSNAPTREEXAM=3; //复查预约
}	
