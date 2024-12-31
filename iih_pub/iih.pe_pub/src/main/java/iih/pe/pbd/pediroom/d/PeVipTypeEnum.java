package iih.pe.pbd.pediroom.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PeVipTypeEnum {

    @DmEnumDesc(name="普通",description="仅适用于普通")
	public static final Integer ONLYNORMUSE=0; //普通
    @DmEnumDesc(name="VIP适用",description="普通与VIP均可用")
	public static final Integer NORMVIPOK=1; //VIP适用
    @DmEnumDesc(name="VIP专用",description="仅VIP可用")
	public static final Integer ONLYVIPUSE=2; //VIP专用
}	
