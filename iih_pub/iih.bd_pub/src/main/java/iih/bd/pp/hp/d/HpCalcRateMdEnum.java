package iih.bd.pp.hp.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface HpCalcRateMdEnum {

    @DmEnumDesc(name="外部计算",description="")
	public static final Integer EXTERNALCALC=0; //外部计算
    @DmEnumDesc(name="内部计算",description="")
	public static final Integer INTERNALCALC=1; //内部计算
}	
