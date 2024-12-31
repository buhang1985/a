package iih.hp.cp.ele.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PkgItemSelectType {

    @DmEnumDesc(name="全选",description="")
	public static final Integer ALLSELECT=1; //全选
    @DmEnumDesc(name="单选",description="")
	public static final Integer SINGLESELECT=2; //单选
    @DmEnumDesc(name="多选",description="")
	public static final Integer MULTISELECT=3; //多选
}	
