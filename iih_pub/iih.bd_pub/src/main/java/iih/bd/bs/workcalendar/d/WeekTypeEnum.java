package iih.bd.bs.workcalendar.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface WeekTypeEnum {

    @DmEnumDesc(name="日",description="周日")
	public static final Integer SUNDAY=0; //日
    @DmEnumDesc(name="一",description="周一")
	public static final Integer MONDAY=1; //一
    @DmEnumDesc(name="二",description="周二")
	public static final Integer TUESDAY=2; //二
    @DmEnumDesc(name="三",description="周三")
	public static final Integer WEDNESDAY=3; //三
    @DmEnumDesc(name="四",description="周四")
	public static final Integer THURSDAY=4; //四
    @DmEnumDesc(name="五",description="周五")
	public static final Integer FRIDAY=5; //五
    @DmEnumDesc(name="六",description="周六")
	public static final Integer SATURDAY=6; //六
}	
