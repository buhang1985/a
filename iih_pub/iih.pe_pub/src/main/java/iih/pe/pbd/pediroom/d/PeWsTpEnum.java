package iih.pe.pbd.pediroom.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PeWsTpEnum {

    @DmEnumDesc(name="登记",description="登记")
	public static final Integer PEWSREG=1; //登记
    @DmEnumDesc(name="咨询",description="咨询")
	public static final Integer PEWSCONSULT=2; //咨询
    @DmEnumDesc(name="分检",description="分检")
	public static final Integer PEWSDOCTOR=3; //分检
    @DmEnumDesc(name="控制台",description="控制台")
	public static final Integer PEWSNURSE=4; //控制台
    @DmEnumDesc(name="餐厅",description="餐厅")
	public static final Integer PEWSDININGROOM=5; //餐厅
    @DmEnumDesc(name="总检",description="总检")
	public static final Integer PEWSGENERAL=6; //总检
}	
