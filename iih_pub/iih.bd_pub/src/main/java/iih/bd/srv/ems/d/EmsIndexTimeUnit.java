package iih.bd.srv.ems.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EmsIndexTimeUnit {

    @DmEnumDesc(name="小时",description="小时")
	public static final Integer HOUR=0; //小时
    @DmEnumDesc(name="天",description="天")
	public static final Integer DAY=1; //天
    @DmEnumDesc(name="月",description="月")
	public static final Integer MONTH=2; //月
}	
