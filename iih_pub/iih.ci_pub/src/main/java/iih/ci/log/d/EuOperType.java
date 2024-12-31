package iih.ci.log.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EuOperType {

    @DmEnumDesc(name="医疗单开立",description="")
	public static final Integer MEDOPEN=0; //医疗单开立
    @DmEnumDesc(name="医嘱模版开立",description="")
	public static final Integer MODELOPEN=1; //医嘱模版开立
    @DmEnumDesc(name="签署",description="")
	public static final Integer SIGN=2; //签署
    @DmEnumDesc(name="删除",description="")
	public static final Integer DELETE=3; //删除
    @DmEnumDesc(name="撤回",description="")
	public static final Integer REVOKE=4; //撤回
    @DmEnumDesc(name="打印",description="")
	public static final Integer PRINT=5; //打印
    @DmEnumDesc(name="作废",description="")
	public static final Integer OBSOLOTE=6; //作废
    @DmEnumDesc(name="补临时",description="")
	public static final Integer TEMPOR=7; //补临时
    @DmEnumDesc(name="复制",description="")
	public static final Integer COPY=8; //复制
    @DmEnumDesc(name="另存为模版",description="")
	public static final Integer SAVE=9; //另存为模版
    @DmEnumDesc(name="护士补费",description="")
	public static final Integer NURFEE=10; //护士补费
    @DmEnumDesc(name="护士确认",description="")
	public static final Integer NURCONFIRM=11; //护士确认
}	
