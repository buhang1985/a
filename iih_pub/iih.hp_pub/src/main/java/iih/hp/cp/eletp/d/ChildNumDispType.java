package iih.hp.cp.eletp.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface ChildNumDispType {

    @DmEnumDesc(name="不显示编号",description="")
	public static final Integer HIDENUM=0; //不显示编号
    @DmEnumDesc(name="字母",description="")
	public static final Integer LETTER=1; //字母
    @DmEnumDesc(name="阿拉伯数字",description="")
	public static final Integer ARAB=2; //阿拉伯数字
    @DmEnumDesc(name="罗马数字",description="")
	public static final Integer ROMAN=3; //罗马数字
}	
