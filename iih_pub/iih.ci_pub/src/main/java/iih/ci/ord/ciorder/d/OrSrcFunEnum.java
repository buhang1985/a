package iih.ci.ord.ciorder.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface OrSrcFunEnum {

    @DmEnumDesc(name="医嘱",description="医嘱")
    public static final String ORDER="1"; //医嘱
    @DmEnumDesc(name="护嘱",description="护嘱")
    public static final String NURORDER="2"; //护嘱
}	
