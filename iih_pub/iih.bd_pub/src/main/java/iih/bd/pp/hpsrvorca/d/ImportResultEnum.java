package iih.bd.pp.hpsrvorca.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface ImportResultEnum {

    @DmEnumDesc(name="无差异",description="成功")
	public static final Integer SAME=0; //无差异
    @DmEnumDesc(name="存在差异",description="存在差异")
	public static final Integer DIFF=1; //存在差异
    @DmEnumDesc(name="找不到对应服务",description="找不到对应服务")
	public static final Integer SRVNOTFOUND=2; //找不到对应服务
    @DmEnumDesc(name="找不到对应物品",description="找不到对应物品")
	public static final Integer MMNOTFOUND=3; //找不到对应物品
    @DmEnumDesc(name="导入数据错误",description="导入数据不合法")
	public static final Integer IMPORTDATAERROR=4; //导入数据错误
    @DmEnumDesc(name="找不到对应通用医保目录类型",description="找不到对应通用医保目录类型")
	public static final Integer HPSRVTPNOTFOUND=5; //找不到对应通用医保目录类型
    @DmEnumDesc(name="导入成功",description="导入成功")
	public static final Integer IMPORTSUCCESS=6; //导入成功
    @DmEnumDesc(name="重复",description="重复")
	public static final Integer REPEAT=7; //重复
}	
