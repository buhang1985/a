package iih.mi.mibd.docenum.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface CompAuditState {

    @DmEnumDesc(name="审核通过",description="审核通过")
    public static final String AUDITED="1"; //审核通过
    @DmEnumDesc(name="驳回",description="驳回")
    public static final String REJECT="2"; //驳回
}	
