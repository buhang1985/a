package iih.mi.itf2.dto.midirsave.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface MiDirSaveEnum {

    @DmEnumDesc(name="医保平台上下文",description="")
    public static final String MICONTEXT="micontext"; //医保平台上下文
    @DmEnumDesc(name="任务注册编码",description="")
    public static final String MIDIRSAVETASK="MIDIRSAVETASK"; //任务注册编码
    @DmEnumDesc(name="任务注册参数",description="")
    public static final String PARAM="param"; //任务注册参数
}	
