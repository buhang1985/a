package iih.mi.mibd.stdsrvtp.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface GeneralReimbursementLevel {

    @DmEnumDesc(name="无自付",description="")
	public static final Integer NOPAY=1; //无自付
    @DmEnumDesc(name="有自付",description="")
	public static final Integer PAID=2; //有自付
    @DmEnumDesc(name="保内全自付",description="结算时，数据需要上传医保")
	public static final Integer PAYINFULL=3; //保内全自付
    @DmEnumDesc(name="保外全自付",description="结算时，数据不需要上传医保")
	public static final Integer OUTOFPOCKET=4; //保外全自付
}	