package iih.bd.pp.feeprojectrejectplan.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface ComplementaryInsertSelectEnum {

    @DmEnumDesc(name="价格升序",description="PRICE_UP")
    public static final String PRICE_UP="1"; //价格升序
    @DmEnumDesc(name="价格倒序",description="PRICE_DOWN")
    public static final String PRICE_DOWN="2"; //价格倒序
}	
