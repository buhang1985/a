package iih.bd.srv.srvrtctl.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface DirectEnum {

    @DmEnumDesc(name="加项",description="增加的服务项目")
	public static final Integer ADD=1; //加项
    @DmEnumDesc(name="减项",description="减少的服务项目")
	public static final Integer MINUS=-1; //减项
}	
