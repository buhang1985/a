package iih.pe.pitm.penarratesportrecipe.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PeAgeGroupingEnum {

    @DmEnumDesc(name="婴儿",description="婴儿")
	public static final Integer PEBABY=1; //婴儿
    @DmEnumDesc(name="幼儿",description="幼儿")
	public static final Integer PEYOUNGCHILD=2; //幼儿
    @DmEnumDesc(name="少年",description="少年")
	public static final Integer PETEENAGES=3; //少年
    @DmEnumDesc(name="青年",description="青年")
	public static final Integer PEYOUTH=4; //青年
    @DmEnumDesc(name="成年",description="成年")
	public static final Integer PEADULT=5; //成年
    @DmEnumDesc(name="中年",description="中年")
	public static final Integer PEMIDDLEAGED=6; //中年
    @DmEnumDesc(name="老年",description="老年")
	public static final Integer PEELDERLY=7; //老年
}	
