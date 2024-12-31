package iih.bd.pp.feeprojectrejectplan.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface DiffProjectExclusionEnum {

    @DmEnumDesc(name="不插入",description="NOT_INSERT")
    public static final String NOT_INSERT="0"; //不插入
    @DmEnumDesc(name="先退后插",description="BACK_INSERT")
    public static final String BACK_INSERT="1"; //先退后插
}	
