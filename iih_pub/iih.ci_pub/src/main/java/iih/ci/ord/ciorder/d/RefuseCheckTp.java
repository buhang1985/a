package iih.ci.ord.ciorder.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface RefuseCheckTp {

    @DmEnumDesc(name="拒绝签署确认",description="拒绝签署确认")
    public static final String REFUSE_SIGN_CHECK="0"; //拒绝签署确认
    @DmEnumDesc(name="拒绝停止确认",description="拒绝停止确认")
    public static final String REFUSE_STOP_CHECK="1"; //拒绝停止确认
    @DmEnumDesc(name="拒绝作废确认",description="拒绝作废确认")
    public static final String REFUSE_CANC_CHECK="2"; //拒绝作废确认
}	
