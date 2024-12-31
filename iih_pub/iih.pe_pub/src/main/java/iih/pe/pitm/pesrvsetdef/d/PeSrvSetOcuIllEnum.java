package iih.pe.pitm.pesrvsetdef.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PeSrvSetOcuIllEnum {

    @DmEnumDesc(name="目标疾病",description="目标疾病")
	public static final Integer PESRVSETTARGET=1; //目标疾病
    @DmEnumDesc(name="职业禁忌证",description="职业禁忌证")
	public static final Integer PESRVSETCONTRAINDICATION=2; //职业禁忌证
}	
