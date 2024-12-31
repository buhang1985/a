package iih.bl.hp.dto.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EuDependRsn {

    @DmEnumDesc(name="适应症依赖",description="适应症依赖")
    public static final String INDICATION="01"; //适应症依赖
    @DmEnumDesc(name="特殊病依赖",description="特殊病依赖")
    public static final String SPECDI="02"; //特殊病依赖
    @DmEnumDesc(name="超量开药依赖",description="超量开药依赖")
    public static final String EXCESSBILL="03"; //超量开药依赖
}	
