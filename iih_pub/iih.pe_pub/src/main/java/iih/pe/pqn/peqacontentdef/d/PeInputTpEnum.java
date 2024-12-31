package iih.pe.pqn.peqacontentdef.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PeInputTpEnum {

    @DmEnumDesc(name="文本",description="文本")
	public static final Integer PEINPUTTEXT=1; //文本
    @DmEnumDesc(name="数字",description="数字")
	public static final Integer PEINPUTNUM=2; //数字
    @DmEnumDesc(name="日期",description="日期")
	public static final Integer PEINPUTDATE=3; //日期
}	
