package iih.nm.nqm.dto.nqmchktable.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface HorizontalEnum {

    @DmEnumDesc(name="左对齐",description="左对齐")
	public static final Integer LEFT=0; //左对齐
    @DmEnumDesc(name="居中",description="居中")
	public static final Integer CENTER=1; //居中
    @DmEnumDesc(name="右对齐",description="右对齐")
	public static final Integer RIGHT=2; //右对齐
}	
