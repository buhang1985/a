package iih.mp.dg.ipdgapp.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface IpDgDispStatusEnum {

    @DmEnumDesc(name="未发药",description="未发药（确认）")
	public static final Integer UNDISPENSE=0; //未发药
    @DmEnumDesc(name="已确认",description="（科室）已确认")
	public static final Integer DISPENSED=1; //已确认
    @DmEnumDesc(name="药房拒绝",description="药房拒绝")
	public static final Integer DEPREJECTED=2; //药房拒绝
}	
