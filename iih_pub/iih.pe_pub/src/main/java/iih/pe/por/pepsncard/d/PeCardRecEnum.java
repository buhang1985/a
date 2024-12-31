package iih.pe.por.pepsncard.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PeCardRecEnum {

    @DmEnumDesc(name="发卡",description="新发卡")
	public static final Integer PECARDNEW=1; //发卡
    @DmEnumDesc(name="补卡",description="挂失，补卡")
	public static final Integer PECARDRENEW=2; //补卡
    @DmEnumDesc(name="转让",description="转让过户")
	public static final Integer PECARDTRANS=3; //转让
    @DmEnumDesc(name="退卡",description="退卡，注销")
	public static final Integer PECARDRETURN=4; //退卡
    @DmEnumDesc(name="停卡",description="暂时停止使用")
	public static final Integer PECARDPAUSE=5; //停卡
    @DmEnumDesc(name="停卡启用",description="暂停后再启用")
	public static final Integer PECARDREUSE=6; //停卡启用
}	
