package iih.mp.mpbd.prnca.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EnumDateTp {

    @DmEnumDesc(name="单天查询",description="单天查询")
	public static final Integer DATE=0; //单天查询
    @DmEnumDesc(name="天区间查询",description="天区间查询")
	public static final Integer DATES=1; //天区间查询
    @DmEnumDesc(name="时间区间查询",description="时间区间查询")
	public static final Integer DATETIMES=2; //时间区间查询
}	
