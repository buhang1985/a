package iih.hp.cp.hpcp.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface Enbltp {

    @DmEnumDesc(name="全院",description="")
	public static final Integer GLOBAL=0;
    @DmEnumDesc(name="科室",description="")
	public static final Integer DEPT=1;
    @DmEnumDesc(name="医生个人",description="")
	public static final Integer PSN=2;
}	
