package iih.en.pv.pativisit.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EuEntContTp {

    @DmEnumDesc(name="联系人",description="")
	public static final Integer CONTACT=1; //联系人
    @DmEnumDesc(name="代办人",description="")
	public static final Integer AGENT=2; //代办人
    @DmEnumDesc(name="父亲",description="")
	public static final Integer FATHER=3; //父亲
    @DmEnumDesc(name="母亲",description="")
	public static final Integer MOTHER=4; //母亲
    @DmEnumDesc(name="担保人",description="")
	public static final Integer SURETY=5; //担保人
}	
