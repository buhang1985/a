package iih.bd.pp.anhuiinsur.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface RxFlag {

    @DmEnumDesc(name="非处方药",description="非处方药")
    public static final String OTC="0"; //非处方药
    @DmEnumDesc(name="处方药",description="处方药")
    public static final String RX="1"; //处方药
}	
