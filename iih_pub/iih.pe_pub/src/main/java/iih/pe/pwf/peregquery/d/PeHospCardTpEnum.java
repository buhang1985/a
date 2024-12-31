package iih.pe.pwf.peregquery.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PeHospCardTpEnum {

    @DmEnumDesc(name="就诊卡",description="就诊卡")
	public static final Integer PEHOSPCARD=1; //就诊卡
    @DmEnumDesc(name="医保卡",description="医保卡")
	public static final Integer PEMEDINSCARD=2; //医保卡
}	
