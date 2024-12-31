package iih.pi.card.card.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface CardSuEnum {

    @DmEnumDesc(name="空白",description="空白")
	public static final Integer BLANK=0; //空白
    @DmEnumDesc(name="在用",description="在用")
	public static final Integer USING=1; //在用
    @DmEnumDesc(name="挂失",description="挂失")
	public static final Integer LOSE=2; //挂失
    @DmEnumDesc(name="注销",description="注销")
	public static final Integer CANCEL=3; //注销
}	
