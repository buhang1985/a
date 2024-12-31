package iih.pmp.pay.ordrstdto.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface BizStatusEnum {

    @DmEnumDesc(name="成功",description="")
	public static final Integer BIZ_SUCCESS=0; //成功
    @DmEnumDesc(name="失败",description="")
	public static final Integer BIZ_FAIL=1; //失败
}	
