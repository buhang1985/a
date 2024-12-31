package iih.bd.fc.enstate.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EuWhere {

    @DmEnumDesc(name="无固定点显示",description="")
    public static final String ANYWHERE="0"; //无固定点显示
    @DmEnumDesc(name="病区床位卡",description="")
    public static final String BEDCARD="1"; //病区床位卡
    @DmEnumDesc(name="科室患者列表",description="")
    public static final String PATLIST="2"; //科室患者列表
    @DmEnumDesc(name="病区和科室患者列表",description="")
    public static final String NURANDPATLIST="3"; //病区和科室患者列表
}	
