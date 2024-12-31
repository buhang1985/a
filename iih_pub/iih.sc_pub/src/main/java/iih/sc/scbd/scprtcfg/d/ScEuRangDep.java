package iih.sc.scbd.scprtcfg.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface ScEuRangDep {

    @DmEnumDesc(name="全院",description="全院")
    public static final String ALL="0"; //全院
    @DmEnumDesc(name="科室",description="科室")
    public static final String DEPT="1"; //科室
}	
