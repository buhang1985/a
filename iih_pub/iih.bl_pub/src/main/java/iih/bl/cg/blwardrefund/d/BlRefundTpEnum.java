package iih.bl.cg.blwardrefund.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface BlRefundTpEnum {

    @DmEnumDesc(name="记账明细",description="cgdetailed")
	public static final Integer CGDETAILED=1; //记账明细
    @DmEnumDesc(name="医嘱",description="ciorder")
	public static final Integer CIORDER=2; //医嘱
}	
