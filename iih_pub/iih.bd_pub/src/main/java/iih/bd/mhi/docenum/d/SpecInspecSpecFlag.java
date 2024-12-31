package iih.bd.mhi.docenum.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface SpecInspecSpecFlag {

    @DmEnumDesc(name="普通项目",description="普通项目")
    public static final String ORDINARYITEMS="0"; //普通项目
    @DmEnumDesc(name="特检特制项目",description="特检特制项目")
    public static final String SISITEMS="1"; //特检特制项目
}	
