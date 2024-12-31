package iih.pis.ivx.pisivxmat.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PisivxCardEnum {

    @DmEnumDesc(name="idcard",description="身份证")
	public static final Integer PISIVXIDCARD=1; //idcard
    @DmEnumDesc(name="insurecard",description="社保卡")
	public static final Integer PISIVXINSURECARD=2; //insurecard
}	
