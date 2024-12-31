package iih.mp.nr.skinrcod.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EnumSkinRstRcod {

    @DmEnumDesc(name="新增",description="新增")
	public static final Integer NEW=0; //新增
    @DmEnumDesc(name="编辑",description="编辑")
	public static final Integer UPDATE=1; //编辑
    @DmEnumDesc(name="清空",description="清空")
	public static final Integer CLEAR=2; //清空
}	
