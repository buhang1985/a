package iih.en.pv.dto.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface CheckStatus {

    @DmEnumDesc(name="未检查",description="未检查")
	public static final Integer NOCHECK=-1; //未检查
    @DmEnumDesc(name="通过",description="通过")
	public static final Integer SUCCESS=0; //通过
    @DmEnumDesc(name="警告",description="警告")
	public static final Integer WARN=1; //警告
    @DmEnumDesc(name="错误",description="错误")
	public static final Integer ERROR=2; //错误
}	
