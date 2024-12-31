package iih.pe.pitm.pesrvitem.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PeItemWarnLevelEnum {

    @DmEnumDesc(name="红",description="红")
	public static final Integer PEITEMWARNRED=4; //红
    @DmEnumDesc(name="橙",description="橙")
	public static final Integer PEITEMWARNORANGE=3; //橙
    @DmEnumDesc(name="黄",description="黄")
	public static final Integer PEITEMWARNYELLOW=2; //黄
    @DmEnumDesc(name="蓝",description="蓝")
	public static final Integer PEITEMWARNBLUE=1; //蓝
}	
