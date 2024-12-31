package iih.bd.srv.srvselfcaitm.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface eudirect {

    @DmEnumDesc(name="增项",description="")
	public static final Integer ADDI=1; //增项
    @DmEnumDesc(name="减项",description="")
	public static final Integer REDUCEI=-1; //减项
}	
