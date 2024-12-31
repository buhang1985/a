package iih.bd.srv.srvskintestrel.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface SkinTestRelTp {

    @DmEnumDesc(name="皮试项目",description="皮试项目")
    public static final String SKINTESTITEM="1"; //皮试项目
    @DmEnumDesc(name="药品基本分类",description="药品基本分类")
    public static final String DRUGCATE="2"; //药品基本分类
}	
