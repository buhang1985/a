package iih.mi.itf2.dto.midirdownload.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface MiDirEnum {

    @DmEnumDesc(name="药品目录",description="")
    public static final String MIDIRDRUG="1"; //药品目录
    @DmEnumDesc(name="诊疗目录",description="")
    public static final String MIDIRSRV="2"; //诊疗目录
    @DmEnumDesc(name="服务设施目录",description="")
    public static final String MIDIRFACILITY="3"; //服务设施目录
    @DmEnumDesc(name="耗材目录",description="")
    public static final String MIDIRMC="4"; //耗材目录
    @DmEnumDesc(name="病种(诊断)目录",description="")
    public static final String MIDIRDI="5"; //病种(诊断)目录
}	
