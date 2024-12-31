package iih.pe.pds.pedsprod.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PeDsProdAlgEnum {

    @DmEnumDesc(name="Apriori",description="Apriori")
	public static final Integer PEAPRIORI=1; //Apriori
    @DmEnumDesc(name="FPGrowth",description="FPGrowth")
	public static final Integer PEFPGROWTH=2; //FPGrowth
}	
