package iih.pe.pitm.pesrvitemroom.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PeRmItmRelEnum {

    @DmEnumDesc(name="检查结果",description="检查结果")
	public static final Integer PERMITMINCLUDE=1; //检查结果
    @DmEnumDesc(name="重点关注",description="重点关注")
	public static final Integer PERMITMTIP=2; //重点关注
}	
