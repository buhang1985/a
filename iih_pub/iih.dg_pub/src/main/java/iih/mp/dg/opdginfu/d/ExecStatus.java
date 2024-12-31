package iih.mp.dg.opdginfu.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface ExecStatus {

    @DmEnumDesc(name="未执行",description="未执行")
	public static final Integer EXEC_NOT=0; //未执行
    @DmEnumDesc(name="正在执行",description="正在执行")
	public static final Integer EXEC_ING=1; //正在执行
    @DmEnumDesc(name="执行完成",description="执行完成")
	public static final Integer EXEC_ED=2; //执行完成
    @DmEnumDesc(name="带走",description="带走")
	public static final Integer TAKE_OUT=9; //带走
}	
