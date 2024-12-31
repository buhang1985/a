package iih.mbh.nm.nhrscheddata.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface StatusEnum {

    @DmEnumDesc(name="无状态",description="无状态")
	public static final Integer UNCHECK=0; //无状态
    @DmEnumDesc(name="更新",description="更新")
	public static final Integer UPDATE=1; //更新
    @DmEnumDesc(name="新增",description="新增")
	public static final Integer NEW=2; //新增
    @DmEnumDesc(name="删除",description="删除")
	public static final Integer DELETE=3; //删除
}	
