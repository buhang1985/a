package iih.en.pv.dto.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface CiOrderStatus {

    @DmEnumDesc(name="长期",description="长期")
    public static final String LONG="1"; //长期
    @DmEnumDesc(name="临时",description="临时")
    public static final String TEMP="2"; //临时
    @DmEnumDesc(name="全部",description="全部")
    public static final String ALL="0"; //全部
}	
