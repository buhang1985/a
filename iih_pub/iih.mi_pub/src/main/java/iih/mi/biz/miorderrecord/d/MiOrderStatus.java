package iih.mi.biz.miorderrecord.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface MiOrderStatus {

    @DmEnumDesc(name="初始状态",description="初始状态")
	public static final Integer VALIDSTATUS=0; //初始状态
    @DmEnumDesc(name="医保成功",description="医保成功")
	public static final Integer MISUCESSSTATUS=1; //医保成功
    @DmEnumDesc(name="HIS成功",description="HIS成功")
	public static final Integer HISSUCESSSTATUS=2; //HIS成功
}	
