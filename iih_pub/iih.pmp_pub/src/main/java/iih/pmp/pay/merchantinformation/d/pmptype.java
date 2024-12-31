package iih.pmp.pay.merchantinformation.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface pmptype {

    @DmEnumDesc(name="微信",description="")
	public static final Integer WX=1; //微信
    @DmEnumDesc(name="支付宝",description="")
	public static final Integer ZFB=2; //支付宝
}	
