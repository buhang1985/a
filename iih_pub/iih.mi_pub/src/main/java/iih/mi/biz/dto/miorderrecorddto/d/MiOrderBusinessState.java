package iih.mi.biz.dto.miorderrecorddto.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface MiOrderBusinessState {

    @DmEnumDesc(name="收费",description="收费")
	public static final Integer CHARGE=1; //收费
    @DmEnumDesc(name="退费",description="退费")
	public static final Integer REFUND=2; //退费
    @DmEnumDesc(name="重收",description="重收")
	public static final Integer RECHARGE=3; //重收
}	
