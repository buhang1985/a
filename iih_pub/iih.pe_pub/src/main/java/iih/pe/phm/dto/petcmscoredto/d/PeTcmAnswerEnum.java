package iih.pe.phm.dto.petcmscoredto.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PeTcmAnswerEnum {

    @DmEnumDesc(name="没有（根本不）",description="没有（根本不）")
	public static final Integer PETCMNONE=1; //没有（根本不）
    @DmEnumDesc(name="很少（有一点）",description="很少（有一点）")
	public static final Integer PETCMFEW=2; //很少（有一点）
    @DmEnumDesc(name="有时（有些）",description="有时（有些）")
	public static final Integer PETCMSOMTTIMES=3; //有时（有些）
    @DmEnumDesc(name="经常（相当）",description="经常（相当）")
	public static final Integer PETCMOFFTEN=4; //经常（相当）
    @DmEnumDesc(name="总是（非常）",description="总是（非常）")
	public static final Integer PETCMALWAYS=5; //总是（非常）
}	
