package iih.pis.mbw.pismbwuser.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PisMbwForStusEnum {

    @DmEnumDesc(name="未关注",description="未关注")
	public static final Integer FOCUS=0; //未关注
    @DmEnumDesc(name="已关注",description="已关注")
	public static final Integer UNFOCUS=1; //已关注
}	
