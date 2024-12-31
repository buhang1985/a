package iih.mi.biz.dto.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface HpPatSourceEnum {

    @DmEnumDesc(name="跨省医保",description="跨省医保")
	public static final Integer ACROSSPROV=0; //跨省医保
    @DmEnumDesc(name="省内异地",description="省内异地")
	public static final Integer ALLOPATRYINPROV=1; //省内异地
    @DmEnumDesc(name="省医保",description="省医保")
	public static final Integer LOCAL=2; //省医保
}	
