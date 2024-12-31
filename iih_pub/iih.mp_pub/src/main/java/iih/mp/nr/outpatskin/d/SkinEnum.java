package iih.mp.nr.outpatskin.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface SkinEnum {

    @DmEnumDesc(name="阳性",description="")
	public static final Integer POSITIVE=0; //阳性
    @DmEnumDesc(name="阴性",description="")
	public static final Integer NEGATIVE=1; //阴性
}	
