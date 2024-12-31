package iih.pe.pitm.pesrvsetdef.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PeSrvSetDefEnum {

    @DmEnumDesc(name="体检套餐",description="")
	public static final Integer PESRVSET=1; //体检套餐
    @DmEnumDesc(name="项目组合",description="")
	public static final Integer PESRVITEMCOMB=2; //项目组合
}	
