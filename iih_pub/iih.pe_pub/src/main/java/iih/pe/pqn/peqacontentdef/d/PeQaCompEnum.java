package iih.pe.pqn.peqacontentdef.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PeQaCompEnum {

    @DmEnumDesc(name="单选",description="单选")
	public static final Integer PEQAMULTI=1; //单选
    @DmEnumDesc(name="多选",description="多选")
	public static final Integer PEQASINGLE=2; //多选
    @DmEnumDesc(name="文本",description="文本")
	public static final Integer PEQATEXT=3; //文本
    @DmEnumDesc(name="日期",description="日期")
	public static final Integer PEQADATE=4; //日期
    @DmEnumDesc(name="时间",description="时间")
	public static final Integer PEQATIME=5; //时间
    @DmEnumDesc(name="日期时间",description="日期时间")
	public static final Integer PEQADATETIME=6; //日期时间
    @DmEnumDesc(name="标签",description="标签")
	public static final Integer PEQALABEL=7; //标签
}	
