package iih.en.pv.dto.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EntIpStatusEnum {

    @DmEnumDesc(name="在院",description="在院")
    public static final String INHOS="0"; //在院
    @DmEnumDesc(name="转科",description="转科")
    public static final String TRANDEP="1"; //转科
    @DmEnumDesc(name="出院",description="出院")
    public static final String LEAVEHOS="2"; //出院
    @DmEnumDesc(name="清空",description="清空")
    public static final String ALL="3"; //清空
}	
