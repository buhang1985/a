package iih.bd.pp.opmutextset.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface MutexSettpEnum {

    @DmEnumDesc(name="门诊收费",description="对应节点48201035")
    public static final String OPCHARGE="01"; //门诊收费
    @DmEnumDesc(name="门诊收费（新）",description="对应节点48201050")
    public static final String OPCHARGENEW="02"; //门诊收费（新）
}	
