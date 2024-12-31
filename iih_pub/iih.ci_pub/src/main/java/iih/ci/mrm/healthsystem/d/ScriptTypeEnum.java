package iih.ci.mrm.healthsystem.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface ScriptTypeEnum {

    @DmEnumDesc(name="SQL",description="SQL")
	public static final Integer SQL=01; //SQL
    @DmEnumDesc(name="PYTHON脚本",description="PYTHON脚本")
	public static final Integer PYTHON=02; //PYTHON脚本
    @DmEnumDesc(name=".NET程序集",description=".NET程序集")
	public static final Integer NET=03; //.NET程序集
}	
