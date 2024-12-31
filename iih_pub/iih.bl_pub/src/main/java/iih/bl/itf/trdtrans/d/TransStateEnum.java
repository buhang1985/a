package iih.bl.itf.trdtrans.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface TransStateEnum {

    @DmEnumDesc(name="第三方交易成功",description="TrdSuccess")
	public static final Integer TRDSUCCESS=0; //第三方交易成功
    @DmEnumDesc(name="IIH交易成功",description="IIHSuccess")
	public static final Integer IIHSUCCESS=1; //IIH交易成功
    @DmEnumDesc(name="第三方交易回退",description="TrdRollback")
	public static final Integer TRDROLLBACK=2; //第三方交易回退
    @DmEnumDesc(name="第三方交易失败",description="UnFail")
	public static final Integer UNFAIL=3; //第三方交易失败
}	
