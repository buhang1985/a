package iih.syn.sen.entin.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EnumEntSynTp {

    @DmEnumDesc(name="在院患者",description="在院患者")
	public static final Integer IN=0; //在院患者
    @DmEnumDesc(name="转科患者",description="转科患者")
	public static final Integer OUTDEP=1; //转科患者
    @DmEnumDesc(name="出院患者",description="出院患者")
	public static final Integer OUT=2; //出院患者
}	
