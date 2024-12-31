package iih.bd.srv.maintenancelog.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface ManageActionEnum {

    @DmEnumDesc(name="注册",description="注册")
	public static final Integer REGISTER=10; //注册
    @DmEnumDesc(name="修改",description="修改")
	public static final Integer MODIFY=20; //修改
    @DmEnumDesc(name="删除",description="删除")
	public static final Integer DELETE=30; //删除
    @DmEnumDesc(name="启用",description="启用")
	public static final Integer ENABLE=40; //启用
    @DmEnumDesc(name="停用",description="停用")
	public static final Integer UNENABLE=41; //停用
}	
