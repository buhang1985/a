package iih.mp.nr.dto.infureg.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface IufuExecStatus {

    @DmEnumDesc(name="全部",description="全部")
	public static final Integer ALL=0; //全部
    @DmEnumDesc(name="未执行",description="未执行")
	public static final Integer TOEXEC=1; //未执行
    @DmEnumDesc(name="已执行",description="已执行")
	public static final Integer EXECING=2; //已执行
}	
