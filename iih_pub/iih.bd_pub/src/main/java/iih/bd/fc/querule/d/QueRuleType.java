package iih.bd.fc.querule.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface QueRuleType {

    @DmEnumDesc(name="参数规则",description="参数规则")
	public static final Integer PARAM=0; //参数规则
    @DmEnumDesc(name="外挂函数",description="外挂函数")
	public static final Integer PLUGIN=1; //外挂函数
}	
