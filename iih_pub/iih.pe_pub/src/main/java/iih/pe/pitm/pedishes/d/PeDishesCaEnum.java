package iih.pe.pitm.pedishes.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PeDishesCaEnum {

    @DmEnumDesc(name="主食",description="主食")
	public static final Integer PEMAINFOOD=1; //主食
    @DmEnumDesc(name="菜",description="菜")
	public static final Integer PEDISHES=2; //菜
    @DmEnumDesc(name="汤",description="汤")
	public static final Integer PESOUP=3; //汤
}	
