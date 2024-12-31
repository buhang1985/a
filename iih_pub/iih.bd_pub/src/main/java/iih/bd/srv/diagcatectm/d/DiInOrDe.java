package iih.bd.srv.diagcatectm.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface DiInOrDe {

    @DmEnumDesc(name="增项",description="")
	public static final Integer IN=1; //增项
    @DmEnumDesc(name="减项",description="")
	public static final Integer DE=-1; //减项
}	
