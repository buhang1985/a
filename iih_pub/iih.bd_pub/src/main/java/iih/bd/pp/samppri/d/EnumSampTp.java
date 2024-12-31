package iih.bd.pp.samppri.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EnumSampTp {

    @DmEnumDesc(name="标本类型",description="标本类型")
	public static final Integer SAMPTP=0; //标本类型
    @DmEnumDesc(name="服务项目",description="服务项目")
	public static final Integer SRV=1; //服务项目
}	
