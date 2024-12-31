package iih.ci.mrm.cimrmfileinfo.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EuPatSignEnum {

    @DmEnumDesc(name="患者本人",description="患者本人")
	public static final Integer 患者本人=00; //患者本人
    @DmEnumDesc(name="患者家属",description="患者家属")
	public static final Integer 患者家属=01; //患者家属
    @DmEnumDesc(name="其它",description="其它")
	public static final Integer 其它=99; //其它
}	
