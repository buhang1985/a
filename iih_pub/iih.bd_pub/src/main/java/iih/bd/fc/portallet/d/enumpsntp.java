package iih.bd.fc.portallet.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface enumpsntp {

    @DmEnumDesc(name="人员",description="人员")
	public static final Integer PSN=0;
    @DmEnumDesc(name="用户",description="用户")
	public static final Integer USER=1;
    @DmEnumDesc(name="角色",description="角色")
	public static final Integer ROLE=2;
    @DmEnumDesc(name="用户组",description="用户组")
	public static final Integer USERGRP=3;
    @DmEnumDesc(name="角色组",description="角色组")
	public static final Integer ROLEGRP=4;
}	
