package iih.pe.por.peorder.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PeOrStateEnum {

    @DmEnumDesc(name="潜在订单",description="潜在订单")
	public static final Integer PEORPOTENTIAL=1; //潜在订单
    @DmEnumDesc(name="签署",description="签署")
	public static final Integer PEORSIGNED=2; //签署
    @DmEnumDesc(name="审核中",description="审核中")
	public static final Integer PEORAUDITING=3; //审核中
    @DmEnumDesc(name="审核通过",description="审核通过")
	public static final Integer PEORAUDITPASSED=4; //审核通过
    @DmEnumDesc(name="驳回",description="驳回")
	public static final Integer PEORREJECT=5; //驳回
    @DmEnumDesc(name="作废",description="作废")
	public static final Integer PEOROBSOLETE=6; //作废
}	
