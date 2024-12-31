package iih.bl.cg.extritf.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EuRefundType {

    @DmEnumDesc(name="门诊缴费退费",description="")
    public static final String OPPAY="01"; //门诊缴费退费
    @DmEnumDesc(name="挂号退费",description="")
    public static final String OPREG="02"; //挂号退费
}	
