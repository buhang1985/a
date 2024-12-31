package iih.sc.sch.sctick.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EuAddTickMod {

    @DmEnumDesc(name="正常号",description="")
	public static final Integer ZCH=0; //正常号
    @DmEnumDesc(name="加号",description="")
	public static final Integer JH=1; //加号
    @DmEnumDesc(name="补号",description="")
	public static final Integer BH=2; //补号
    @DmEnumDesc(name="无排班加号",description="")
	public static final Integer WPB=3; //无排班加号
}	
