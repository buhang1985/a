package iih.ci.ord.dws.ip.order.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface OrderPrescribeModuleEnum {

    @DmEnumDesc(name="医嘱列表开立",description="医嘱列表开立")
	public static final Integer ORDERLIST=0; //医嘱列表开立
    @DmEnumDesc(name="申请单开立",description="申请单开立")
	public static final Integer ORDERAPPFORM=1; //申请单开立
    @DmEnumDesc(name="医嘱模板开立",description="医嘱模板开立")
	public static final Integer ORDERTEMP=2; //医嘱模板开立
    @DmEnumDesc(name="临床路径开立",description="临床路径开立")
	public static final Integer HPCPOR=3; //临床路径开立
    @DmEnumDesc(name="其他",description="其他开立方式")
	public static final Integer OTHER=4; //其他
}	
