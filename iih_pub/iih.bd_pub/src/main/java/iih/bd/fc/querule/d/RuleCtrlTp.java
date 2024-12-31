package iih.bd.fc.querule.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface RuleCtrlTp {

    @DmEnumDesc(name="允许加入队列条件",description="允许加入队列条件")
	public static final Integer ALLOWENTRY=1; //允许加入队列条件
    @DmEnumDesc(name="禁止加入队列条件",description="禁止加入队列条件")
	public static final Integer FORBIDENTRY=2; //禁止加入队列条件
    @DmEnumDesc(name="级别控制分类",description="级别控制分类")
	public static final Integer LEVELCTRL=3; //级别控制分类
}	
