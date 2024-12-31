package iih.pe.por.pepsnpot.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PePsnPotEnum {

    @DmEnumDesc(name="目标客户",description="目标客户")
	public static final Integer PEPSNTARGET=1; //目标客户
    @DmEnumDesc(name="潜在客户",description="潜在客户")
	public static final Integer PEPSNPOTENTIAL=2; //潜在客户
    @DmEnumDesc(name="意向客户",description="意向客户")
	public static final Integer PEPSNINTENTION=3; //意向客户
    @DmEnumDesc(name="成交客户",description="成交客户")
	public static final Integer PEPSNTRANSACTION=4; //成交客户
    @DmEnumDesc(name="无效客户",description="无效客户")
	public static final Integer PEPSNINVALID=5; //无效客户
}	
