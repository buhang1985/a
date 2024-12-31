package iih.sc.scp.scplweek.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EuWeekTp {

    @DmEnumDesc(name="周模板",description="")
	public static final Integer WEEK=0; //周模板
    @DmEnumDesc(name="节假日模板",description="")
	public static final Integer HOLIDAY=1; //节假日模板
    @DmEnumDesc(name="日模板",description="")
	public static final Integer DAY=2; //日模板
}	
