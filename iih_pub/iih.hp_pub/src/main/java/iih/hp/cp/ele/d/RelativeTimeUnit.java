package iih.hp.cp.ele.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface RelativeTimeUnit {

    @DmEnumDesc(name="天",description="")
	public static final Integer RELATIVEDAY=0; //天
    @DmEnumDesc(name="小时",description="")
	public static final Integer RELATIVEHOUR=1; //小时
}	
