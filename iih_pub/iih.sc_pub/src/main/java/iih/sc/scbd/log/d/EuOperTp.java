package iih.sc.scbd.log.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EuOperTp {

    @DmEnumDesc(name="新增",description="")
    public static final String INSERT="1"; //新增
    @DmEnumDesc(name="修改",description="")
    public static final String UPDATE="2"; //修改
    @DmEnumDesc(name="删除",description="")
    public static final String DELETE="3"; //删除
    @DmEnumDesc(name="其他",description="")
    public static final String OTHERS="4"; //其他
}	
