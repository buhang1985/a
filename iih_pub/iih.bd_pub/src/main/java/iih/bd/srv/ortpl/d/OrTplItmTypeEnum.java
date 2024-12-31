package iih.bd.srv.ortpl.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface OrTplItmTypeEnum {

    @DmEnumDesc(name="模板",description="基础医嘱模板")
	public static final Integer ORTMPL=0; //模板
    @DmEnumDesc(name="服务",description="医疗服务")
	public static final Integer SRV=1; //服务
    @DmEnumDesc(name="套",description="服务套")
	public static final Integer SRVSET=2; //套
}	
