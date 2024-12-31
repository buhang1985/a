package iih.bd.pp.bdbltpl.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface BdBlTplOwTypeEnum {

    @DmEnumDesc(name="全院权限",description="hospitalAuthority")
	public static final Integer HOSPITALAUTHORITY=0; //全院权限
    @DmEnumDesc(name="科室权限",description="DepAuthority")
	public static final Integer DEPAUTHORITY=1; //科室权限
    @DmEnumDesc(name="医生个人权限",description="Selfauthority")
	public static final Integer SELFAUTHORITY=2; //医生个人权限
}	
