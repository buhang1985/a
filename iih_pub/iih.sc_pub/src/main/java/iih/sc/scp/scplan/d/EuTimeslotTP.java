package iih.sc.scp.scplan.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EuTimeslotTP {

    @DmEnumDesc(name="排班计划时长",description="")
	public static final Integer SINGLE =0; //排班计划时长
    @DmEnumDesc(name="排班服务时长",description="")
	public static final Integer DIC=1; //排班服务时长
    @DmEnumDesc(name="诊疗项目时长",description="")
	public static final Integer SPE=2; //诊疗项目时长
    @DmEnumDesc(name="自定义时长",description="")
	public static final Integer UDI=3; //自定义时长
}	
