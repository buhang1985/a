package iih.ci.log.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface Log_LV {

    @DmEnumDesc(name="调试/正常",description="")
	public static final Integer DEBUG=0; //调试/正常
    @DmEnumDesc(name="信息",description="")
	public static final Integer INFO=1; //信息
    @DmEnumDesc(name="警告",description="")
	public static final Integer WARN=2; //警告
    @DmEnumDesc(name="错误",description="")
	public static final Integer ERROR=3; //错误
}	
