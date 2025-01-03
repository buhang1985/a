package iih.cssd.dpus.dfpisu.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EnumDfpSend {

    @DmEnumDesc(name="新建",description="新建")
	public static final Integer NEW=0; //新建
    @DmEnumDesc(name="发放",description="发放")
	public static final Integer SEND=1; //发放
    @DmEnumDesc(name="拒发",description="拒发")
	public static final Integer REFUSE=2; //拒发
    @DmEnumDesc(name="撤回",description="撤回")
	public static final Integer CALLBACK=3; //撤回
}	
