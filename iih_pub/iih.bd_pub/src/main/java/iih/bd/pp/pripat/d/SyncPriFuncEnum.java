package iih.bd.pp.pripat.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface SyncPriFuncEnum {

    @DmEnumDesc(name="患者价格分类",description="患者价格分类")
    public static final String PRIPAT="01"; //患者价格分类
    @DmEnumDesc(name="价表维护",description="价表维护")
    public static final String PRICELIST="02"; //价表维护
}	
