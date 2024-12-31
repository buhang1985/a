package iih.mbh.nm.nhrflowdata.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface ApplicaTypeEnum {

    @DmEnumDesc(name="全部",description="全部申请")
	public static final Integer TYPE_ALL=0; //全部
    @DmEnumDesc(name="加班申请",description="加班申请")
	public static final Integer TYPE_OVERWORK=1; //加班申请
    @DmEnumDesc(name="替班申请",description="替班申请")
	public static final Integer TYPE_SCHEDRP=2; //替班申请
    @DmEnumDesc(name="请假申请",description="请假申请")
	public static final Integer TYPE_SCHEDLV=3; //请假申请
}	
