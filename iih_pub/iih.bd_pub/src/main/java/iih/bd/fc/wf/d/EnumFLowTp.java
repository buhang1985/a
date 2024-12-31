package iih.bd.fc.wf.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EnumFLowTp {

    @DmEnumDesc(name="执行流向",description="执行流向")
	public static final Integer EXECUTEFLOW=1; //执行流向
    @DmEnumDesc(name="物资流向",description="物资流向")
	public static final Integer SUPPLIESFLOW=2; //物资流向
}	
