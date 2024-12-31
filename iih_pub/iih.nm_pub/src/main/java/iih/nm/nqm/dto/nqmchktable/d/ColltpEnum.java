package iih.nm.nqm.dto.nqmchktable.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface ColltpEnum {

    @DmEnumDesc(name="文本",description="文本")
	public static final Integer COLLTEXT=1; //文本
    @DmEnumDesc(name="数值",description="数值")
	public static final Integer COLLNUMBER=2; //数值
    @DmEnumDesc(name="选择",description="选择")
	public static final Integer COLLSELECT=3; //选择
    @DmEnumDesc(name="平铺单选",description="平铺单选")
	public static final Integer COLLCHECK=4; //平铺单选
    @DmEnumDesc(name="下拉",description="下拉")
	public static final Integer COLLDOWN=5; //下拉
    @DmEnumDesc(name="单选",description="单选")
	public static final Integer COLLSGLSEL=6; //单选
    @DmEnumDesc(name="是否标志",description="标志")
	public static final Integer COLLBOOL=7; //是否标志
}	
