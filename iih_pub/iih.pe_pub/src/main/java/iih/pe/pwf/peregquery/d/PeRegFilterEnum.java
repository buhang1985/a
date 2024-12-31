package iih.pe.pwf.peregquery.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PeRegFilterEnum {

    @DmEnumDesc(name="全部",description="全部")
	public static final Integer PEREGALL=1; //全部
    @DmEnumDesc(name="个检",description="个检")
	public static final Integer PEREGPSN=2; //个检
    @DmEnumDesc(name="团检",description="团检")
	public static final Integer PEREGCORP=3; //团检
}	
