package iih.mp.dg.ipshetp.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface MpSheetTypeEnum {

    @DmEnumDesc(name="西成摆药单",description="西成摆药单")
	public static final Integer WPUT=1; //西成摆药单
    @DmEnumDesc(name="西成退药单",description="退药单")
	public static final Integer WRETURN=2; //西成退药单
    @DmEnumDesc(name="草药摆药单",description="草药摆药单")
	public static final Integer HPUT=11; //草药摆药单
    @DmEnumDesc(name="草药退药单",description="草药退药单")
	public static final Integer HRETURN=12; //草药退药单
}	
