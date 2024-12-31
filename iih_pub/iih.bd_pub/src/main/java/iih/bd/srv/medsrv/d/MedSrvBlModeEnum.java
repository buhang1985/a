package iih.bd.srv.medsrv.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface MedSrvBlModeEnum {

    @DmEnumDesc(name="自动划价",description="自动记费")
	public static final Integer AUTOBL=0; //自动划价
    @DmEnumDesc(name="手工划价",description="手工记费")
	public static final Integer MANUALBL=1; //手工划价
}	
