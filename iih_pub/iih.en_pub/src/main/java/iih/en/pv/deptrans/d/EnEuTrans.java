package iih.en.pv.deptrans.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EnEuTrans {

    @DmEnumDesc(name="申请",description="申请")
	public static final Integer APPLY=0; //申请
    @DmEnumDesc(name="完成",description="完成")
	public static final Integer ACPT=1; //完成
}	
