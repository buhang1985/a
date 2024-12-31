package iih.bd.srv.mrctmca.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface Docornur {

    @DmEnumDesc(name="医生",description="医生")
	public static final Integer DOCTOR=10; //医生
    @DmEnumDesc(name="护士",description="护士")
	public static final Integer NURSE=20; //护士
    @DmEnumDesc(name="医护共享",description="医护共享")
	public static final Integer DOCSNDNUR=30; //医护共享
    @DmEnumDesc(name="医保",description="医保工作人员可见")
	public static final Integer HP=41; //医保
}	
