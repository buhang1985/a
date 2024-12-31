package iih.mp.mpbd.kb.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EuSelectTypes {

    @DmEnumDesc(name="输入",description="输入")
	public static final Integer TYPE_INSERT=0; //输入
    @DmEnumDesc(name="单选",description="单选")
	public static final Integer TYPE_SINGLE=1; //单选
    @DmEnumDesc(name="多选",description="多选")
	public static final Integer TYPE_MULTITY=2; //多选
}	
