package iih.nm.nom.nomwkitm.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EnumDorH {

    @DmEnumDesc(name="时数",description="")
	public static final Integer HOURS=0; //时数
    @DmEnumDesc(name="天数",description="")
	public static final Integer DAYS=1; //天数
}	
