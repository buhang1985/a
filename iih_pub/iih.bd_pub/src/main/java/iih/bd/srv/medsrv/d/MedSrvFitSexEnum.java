package iih.bd.srv.medsrv.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface MedSrvFitSexEnum {

    @DmEnumDesc(name="不限",description="不限")
	public static final Integer UNLIMITED=0; //不限
    @DmEnumDesc(name="男性",description="男性")
	public static final Integer MALE=1; //男性
    @DmEnumDesc(name="女性",description="女性")
	public static final Integer WOMAN=2; //女性
}	
