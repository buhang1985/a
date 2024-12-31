package iih.bd.pp.hp.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface SrvOrCaMdEnum {

    @DmEnumDesc(name="服务项目分类",description="服务项目分类")
	public static final Integer SRVCA=0; //服务项目分类
    @DmEnumDesc(name="服务项目",description="服务项目")
	public static final Integer SRV=1; //服务项目
    @DmEnumDesc(name="混合模式",description="混合模式")
	public static final Integer MIXED=2; //混合模式
}	
