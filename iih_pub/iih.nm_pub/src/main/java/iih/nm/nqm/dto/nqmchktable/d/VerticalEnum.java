package iih.nm.nqm.dto.nqmchktable.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface VerticalEnum {

    @DmEnumDesc(name="居上",description="居上")
	public static final Integer TOP=0; //居上
    @DmEnumDesc(name="居中",description="居中")
	public static final Integer CENTER=1; //居中
    @DmEnumDesc(name="居下",description="居下")
	public static final Integer BOTTOM=2; //居下
}	
