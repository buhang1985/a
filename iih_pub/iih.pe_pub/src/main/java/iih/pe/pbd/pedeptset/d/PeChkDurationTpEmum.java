package iih.pe.pbd.pedeptset.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PeChkDurationTpEmum {

    @DmEnumDesc(name="科室",description="科室")
	public static final Integer PECHKDUDEP=1; //科室
    @DmEnumDesc(name="检查项目基本目录",description="检查项目基本目录")
	public static final Integer PECHKDUCATLOG=2; //检查项目基本目录
    @DmEnumDesc(name="检查结果",description="检查结果")
	public static final Integer PECHKDUITEM=3; //检查结果
}	
