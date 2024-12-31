package iih.bd.fc.orwf.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EnumMacro {

    @DmEnumDesc(name="【开单科室】",description="")
	public static final Integer ORDERDEP=1; //【开单科室】
    @DmEnumDesc(name="【就诊科室】",description="")
	public static final Integer ENTDEP=2; //【就诊科室】
    @DmEnumDesc(name="【临床跟随】",description="执行科室跟随临床项目的执行科室")
	public static final Integer FOLLOWOR=3; //【临床跟随】
    @DmEnumDesc(name="【就诊病区】",description="")
	public static final Integer ENTWARD=11; //【就诊病区】
}	
