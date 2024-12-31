package iih.bl.pay.prepay.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EuPrepayBizType {

    @DmEnumDesc(name="预交金开立记账",description="预交金开立记账")
    public static final String PREPAYOPENCG="1"; //预交金开立记账
    @DmEnumDesc(name="预交金执行记账",description="预交金执行记账")
    public static final String PREPAYMPCG="2"; //预交金执行记账
    @DmEnumDesc(name="高端商保开立记账",description="高端商保开立记账")
    public static final String HIGHCMCLOPENCG="3"; //高端商保开立记账
    @DmEnumDesc(name="高端商保执行记账",description="高端商保执行记账")
    public static final String HIGHCMCLMPCG="4"; //高端商保执行记账
}	
