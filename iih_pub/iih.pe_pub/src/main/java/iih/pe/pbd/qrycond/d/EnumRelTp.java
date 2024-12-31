package iih.pe.pbd.qrycond.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EnumRelTp {

    @DmEnumDesc(name="且",description="且")
	public static final Integer AND=1; //且
    @DmEnumDesc(name="或",description="或")
	public static final Integer OR=2; //或
}	
