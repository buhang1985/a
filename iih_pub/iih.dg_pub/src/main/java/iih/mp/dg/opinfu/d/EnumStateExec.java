package iih.mp.dg.opinfu.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EnumStateExec {

    @DmEnumDesc(name="未执行",description="未执行")
	public static final Integer NOTEXECUTE=0;
    @DmEnumDesc(name="正在执行",description="正在执行")
	public static final Integer EXECUTING=1;
    @DmEnumDesc(name="执行完成",description="执行完成")
	public static final Integer EXECUTED=2;
    @DmEnumDesc(name="带走",description="带走")
	public static final Integer TAKENAWAY=9;
}	
