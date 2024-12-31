package iih.mp.dg.opdrugdisp.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PresChkStatus {

    @DmEnumDesc(name="未审核",description="未审核")
	public static final Integer CHK_NO=0; //未审核
    @DmEnumDesc(name="审核通过",description="审核通过")
	public static final Integer CHK_PASS=1; //审核通过
    @DmEnumDesc(name="审核拒绝",description="审核拒绝")
	public static final Integer CHK_REJECT=2; //审核拒绝
}	
