package iih.ci.ord.cior.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EnumOpAgainChkRst {

    @DmEnumDesc(name="未审批",description="未审批")
    public static final String NULL="0"; //未审批
    @DmEnumDesc(name="同意",description="同意")
    public static final String AGREED ="1"; //同意
    @DmEnumDesc(name="驳回",description="驳回")
    public static final String REJECTED="2"; //驳回
}	
