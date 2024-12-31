package iih.pmp.pay.ordreqdto.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface TradeTypeEnum {

    @DmEnumDesc(name="公众号支付",description="公众号支付")
    public static final String PUBLICPAY="JSAPI"; //公众号支付
    @DmEnumDesc(name="扫码支付",description="扫码支付")
    public static final String SCANPAY="NATIVE"; //扫码支付
    @DmEnumDesc(name="APP支付",description="APP支付")
    public static final String APPPAY="APP"; //APP支付
    @DmEnumDesc(name="H5支付",description="H5支付")
    public static final String H5PAY="MWEB"; //H5支付
}	
