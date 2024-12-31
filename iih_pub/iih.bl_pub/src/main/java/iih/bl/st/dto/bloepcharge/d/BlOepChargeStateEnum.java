package iih.bl.st.dto.bloepcharge.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface BlOepChargeStateEnum {

    @DmEnumDesc(name="初始化",description="没有获得合法的患者信息之前为该状态")
	public static final Integer INIT=0; //初始化
    @DmEnumDesc(name="开始业务",description="业务初始状态，已经加载合法的患者信息，马上开始走正常的业务流程")
	public static final Integer BEGINTRANS=1; //开始业务
    @DmEnumDesc(name="待划价",description="调入收费医嘱，待划价状态")
	public static final Integer PREPRICE=2; //待划价
    @DmEnumDesc(name="已划价",description="已经划价状态")
	public static final Integer PRICED=3; //已划价
    @DmEnumDesc(name="业务结束",description="一次业务流程结束状态")
	public static final Integer TRANSEND=4; //业务结束
}	
