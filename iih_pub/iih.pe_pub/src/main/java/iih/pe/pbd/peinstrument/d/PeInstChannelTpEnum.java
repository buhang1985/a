package iih.pe.pbd.peinstrument.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PeInstChannelTpEnum {

    @DmEnumDesc(name="按设备项目编码对应",description="按设备项目编码对应")
	public static final Integer BYINSTITEMCODEREL=1; //按设备项目编码对应
    @DmEnumDesc(name="按设备项目序号对应",description="按设备项目序号对应")
	public static final Integer BYINSTITEMSEQNOREL=2; //按设备项目序号对应
}	
