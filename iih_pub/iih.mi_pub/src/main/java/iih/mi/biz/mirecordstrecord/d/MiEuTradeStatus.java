package iih.mi.biz.mirecordstrecord.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface MiEuTradeStatus {

    @DmEnumDesc(name="医保半退全退成功",description="医保半退全退成功")
	public static final Integer MIHALFREFUNDSUCESS=1; //医保半退全退成功
    @DmEnumDesc(name="医保退费成功",description="医保退费成功")
	public static final Integer MIREFUNDSUCESS=2; //医保退费成功
    @DmEnumDesc(name="HIS退费成功",description="HIS退费成功")
	public static final Integer HISREFUNDSUCESS=3; //HIS退费成功
    @DmEnumDesc(name="医保收费成功",description="医保收费成功")
	public static final Integer MICHARGESUCESS=4; //医保收费成功
    @DmEnumDesc(name="HIS收费成功",description="HIS收费成功")
	public static final Integer HISCHARGESUCESS=5; //HIS收费成功
}	
