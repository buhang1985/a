package iih.pe.pwf.peregquery.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PePrintEnum {

    @DmEnumDesc(name="全部",description="全部")
	public static final Integer PEPRINTALL=0; //全部
    @DmEnumDesc(name="已打印",description="已打印")
	public static final Integer PEPRINTYES=1; //已打印
    @DmEnumDesc(name="未打印",description="未打印")
	public static final Integer PEPRINTNO=2; //未打印
}	
