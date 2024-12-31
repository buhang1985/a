package iih.pe.pbd.pedeptset.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PeDepInfTpEnum {

    @DmEnumDesc(name="普通界面",description="普通界面")
	public static final Integer PEDEPINFNORMAL=1; //普通界面
    @DmEnumDesc(name="检前咨询",description="检前咨询")
	public static final Integer PEDEPINFCONSULT=2; //检前咨询
    @DmEnumDesc(name="口腔",description="口腔")
	public static final Integer PEDEPINFSTOMATOLOGY=3; //口腔
    @DmEnumDesc(name="中医",description="中医")
	public static final Integer PEDEPINFTCM=4; //中医
}	
